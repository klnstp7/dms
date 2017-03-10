package com.yunfang.dms.utils;

import com.yunfang.dms.dto.InquiryDataDto;
import com.yunfang.dms.dto.TempLateConfigDto;
import com.yunfang.dms.entity.InquiryData;
import com.yunfang.dms.exception.CustomException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hwpf.usermodel.Field;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.sl.draw.binding.ObjectFactory;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.IterateCells;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/2/14.
 */
public class ExcelUtil {

    /*
    * 读取Excel文件，并返回Map,
    *fileName  Excel文件路径
    * Map格式 Map第一条数据为 列头 ，Value 存储格式 <列索引，列值>
    * */
    public static Map<Integer, Map<Integer, String>> readExcel(String fileName) throws CustomException {
        boolean isE2007 = false;    //判断是否是excel2007格式
        List<Object> returnList = new ArrayList<Object>();
        //返回的结果
        Map<Integer, Map<Integer, String>> returnMap = new HashMap<Integer, Map<Integer, String>>();
        if (fileName.endsWith("xlsx"))
            isE2007 = true;
        try {
            String _filename=fileName.substring(fileName.lastIndexOf('\\') + 1);
            InputStream input = new FileInputStream(fileName);  //建立输入流
            Workbook wb = null;
            //根据文件格式(2003或者2007)来初始化
            if (isE2007)
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);

            vaildSheetsIsEquals(wb,_filename);
            Iterator<Sheet> sheets = wb.sheetIterator();
            int sheetLastRowNum = 0;
            int sheetIndex = 0;
            int rowSumCol = 0;
            while (sheets.hasNext()) { //遍历sheet
                Sheet sheet = sheets.next();     //获得第一个表单
                //sheet.getLastRowNum();
                Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
                while (rows.hasNext()) {
                    Row row = rows.next();  //获得行数据
                    //如果是第二个sheet时，直接从第二行开始读取
                    if (sheetIndex > 0 && row.getRowNum() < 1)
                        continue;
                    if (sheetIndex < 1 && row.getRowNum() < 1) {//获取第一个sheet第一行的列头的列数
                        rowSumCol = sheet.getRow(0).getLastCellNum();
                    }
                    Map<Integer, String> colValMap = new HashMap<Integer, String>();//列对应的值
                    //Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器
                    //while (cells.hasNext()) {
                    int colIndex = 0;
                    while (rowSumCol > colIndex) {
                        Cell cell = row.getCell(colIndex);
                        getCellValue(colValMap, colIndex, cell);
                        colIndex++;
                    }
                    int rowNum = row.getRowNum();
                    if (sheetIndex > 0)
                        rowNum = rowNum + 1;
                    returnMap.put(sheetLastRowNum + rowNum, colValMap);
                }
                sheetLastRowNum += (sheet.getLastRowNum());
                sheetIndex++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return returnMap;
    }

    private static void getCellValue(Map<Integer, String> colValMap, int colIndex, Cell cell) {
        Object colValue;
        if (cell != null) {
            switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
                        colValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                    } else {
                        colValue = cell.getNumericCellValue();
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    colValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    colValue = cell.getBooleanCellValue();
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    colValue = cell.getCellFormula();
                    break;
                default:
                    colValue = cell.getStringCellValue();
                    break;
            }
            colValMap.put(colIndex, colValue.toString());
        } else {
            colValMap.put(colIndex, "");
        }
    }

    /*
    * 验证Excel中每个sheet中的列头是否一致
    * */
    private static void vaildSheetsIsEquals(Workbook wb,String fileName) throws CustomException {
        Iterator<Sheet> sheets = wb.sheetIterator();
        Map<Integer, Map<Integer, String>> returnMap = new LinkedHashMap<Integer, Map<Integer, String>>();
        int sheetIndex=0;
        while (sheets.hasNext()) { //遍历sheet
            Sheet sheet = sheets.next();     //获得第一个表单
            //获取第一行
            Row firstRow = sheet.getRow(0);
            if(firstRow==null)
                continue;
            Map<Integer, String> colValMap = new LinkedHashMap<Integer, String>();//列对应的值
            Iterator<Cell> cells = firstRow.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                getCellValue(colValMap,cell.getColumnIndex(),cell);
            }
            returnMap.put(sheetIndex,colValMap);
            sheetIndex++;
        }
        if(returnMap.size()<2)
            return;
        Map<Integer, String> prevalue=null;
        for (Map.Entry<Integer, Map<Integer, String>> entry:returnMap.entrySet()){
            Map<Integer, String> value=entry.getValue();
            if(prevalue==null){
                prevalue=value;
                continue;
            }
            if(!value.equals(prevalue))
            {
                throw new CustomException(fileName+",Excel中列头不统一(顺序和名称必须一致)，请检查后再上传!");
            }
        }
    }


    /*
    * 导出错数据
    * */
    @SuppressWarnings("unchecked")
    public static void exportJsonToExcel(String fileName, Map<String, TempLateConfigDto> configColMap, JSONArray jsonArray, HttpServletResponse response) {
        try {
            // 新建文件
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("失败的数据");
            HSSFRow row = sheet.createRow((int) 0);
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            int ih = 0;
            for (Map.Entry<String, TempLateConfigDto> key : configColMap.entrySet()) {
                HSSFCell cell = row.createCell(ih);
                cell.setCellValue(key.getValue().getTemplateCol());
                cell.setCellStyle(style);
                sheet.autoSizeColumn(ih);
                ih++;
            }
            int column = 0; // 列数计数
            // 遍历jsonArray
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项
                row = sheet.createRow(i + 1);
                column = 0;// 从第0列开始放
                for (Map.Entry<String, TempLateConfigDto> key : configColMap.entrySet()) {
                    try {
                        String value = item.getString(key.getKey()); // 得到key对应的value
                        row.createCell(column).setCellValue(value);
                    } catch (Exception ex) {
                        row.createCell(column).setCellValue("");
                    }
                    column++;
                }
            }
            response.setContentType("application/vnd.ms-excel");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls;");
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
