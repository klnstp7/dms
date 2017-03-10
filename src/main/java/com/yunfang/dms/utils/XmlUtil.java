package com.yunfang.dms.utils;

import com.yunfang.dms.dto.TempLateConfigDto;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by Administrator on 2017/2/15.
 */
public class XmlUtil {
    public static Map<String, TempLateConfigDto> getConfigForInput(String nodeName, String keyType) {
        String resourcePath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        try{
            resourcePath= URLDecoder.decode(resourcePath,"utf-8");
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new File(resourcePath + "/entity-template-ref.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 获取根元素
        Element root = document.getRootElement();
        List<Node> childList = document.selectNodes("root/" + nodeName + "/item");
        Map<String, TempLateConfigDto> map = new LinkedHashMap<String, TempLateConfigDto>();
        for (Iterator iter = childList.listIterator(); iter.hasNext(); ) {
            Element e = (Element) iter.next();
            TempLateConfigDto dto = new TempLateConfigDto();
            dto.setDataType(e.attributeValue("datatype"));
            dto.setEntityCol(e.attributeValue("entitycol"));
            dto.setIsNull(Boolean.parseBoolean(e.attributeValue("isnull")));
            dto.setTemplateCol(e.attributeValue("templatecol"));
            if (keyType.equals("tempLate")) {
                map.put(e.attributeValue("templatecol"), dto);
            } else {
                map.put(e.attributeValue("entitycol"), dto);
            }
        }
        //return sortMap(map);
        return map;
    }

    public static Map<String,TempLateConfigDto> sortMap(Map<String, TempLateConfigDto> map_Data) {
        //将Map转化为List集合，List采用ArrayList
        List<Map.Entry<String, TempLateConfigDto>> list_Data = new ArrayList<Map.Entry<String, TempLateConfigDto>>(map_Data.entrySet());
        //通过Collections.sort(List I,Comparator c)方法进行排序
        //Collections.sort(list_Data, new Comparator<Map.Entry<String, TempLateConfigDto>>() {
        //    @Override
        //    public int compare(Map.Entry<String, TempLateConfigDto> o1, Map.Entry<String, TempLateConfigDto> o2) {
        //        return (o1.getValue().getColSort() - o2.getValue().getColSort());
        //    }
        //});
        Map<String,TempLateConfigDto> map=new HashMap<String,TempLateConfigDto>();//list转map
        for(Map.Entry<String, TempLateConfigDto> t : list_Data){
            map.put(t.getKey(),t.getValue());
        }
        return map;
    }
}
