package com.yunfang.dms.controller;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yunfang.dms.utils.ExcelUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
@RequestMapping("/upload")
public class UploadController   {
    private static final int BUFF_SIZE = 1024 * 1024;
    // 附件上传
    @RequestMapping("/uploadAttach")
    public void attachUpload(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String dataType=request.getParameter("dataType");
        String savePath = request.getSession().getServletContext().getRealPath("/") + "upload";
        File f1 = new File(savePath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            ex.printStackTrace();
            return;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        //存储完毕保存进入数据库
        //Document document = null;
    while (it.hasNext()) {
        FileItem item = it.next();
        if (!item.isFormField()) {
            name = item.getName();
            long size = item.getSize();
            String type = item.getContentType();
            if (name == null || name.trim().equals("")) {
                continue;
            }
            //扩展名格式：
            if (name.lastIndexOf(".") >= 0) {
               name.substring(name.lastIndexOf("."));
            }
            File saveFile = new File(savePath + "/" + name);
            try {
                item.write(saveFile);
                if(dataType.equals("doc")){
                if(!saveFile.getName().endsWith(".rar")){
                    unZipFiles(saveFile,savePath+"/unzip/"+name);
                }
                else{
                   unRarFile(saveFile.getPath(),savePath+"/unzip/"+name);
                }
                }
                else
                {
                    ExcelUtil.readExcel(saveFile.getPath());
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(new Date() + "store file error");
            }
        }
    }
    response.getWriter().print(name + "@" + name);
    }

    /*
    * 解压文件夹
    * */
    @SuppressWarnings("rawtypes")
    public void unZipFiles(File zipFile,String descDir)throws IOException{
        File pathFile = new File(descDir);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for(Enumeration entries = zip.getEntries();entries.hasMoreElements();){
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir+"/"+zipEntryName).replaceAll("\\*", "/");;
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if(!file.exists()){
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if(new File(outPath).isDirectory()){
                continue;
            }
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while((len=in.read(buf1))>0){
                out.write(buf1,0,len);
            }
            in.close();
            out.close();
        }
    }
    /**
     * 根据原始rar路径，解压到指定文件夹下.
     * @param srcRarPath 原始rar路径
     * @param dstDirectoryPath 解压到的文件夹
     */
    @SuppressWarnings("rawtypes")
    public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            return;
        }
        File dstDiretory = new File(dstDirectoryPath);
        if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
            dstDiretory.mkdirs();
        }
        Archive a = null;
        try {
            a = new Archive(new File(srcRarPath));
            if (a != null) {
                a.getMainHeader().print(); // 打印文件信息.
                FileHeader fh = a.nextFileHeader();
                while (fh != null) {
                    if (fh.isDirectory()) { // 文件夹
                        File fol = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString());
                        fol.mkdirs();
                    } else { // 文件
                        File out = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString().trim());
                        //System.out.println(out.getAbsolutePath());
                        try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压.
                            if (!out.exists()) {
                                if (!out.getParentFile().exists()) {// 相对路径可能多级，可能需要创建父目录.
                                    out.getParentFile().mkdirs();
                                }
                                out.createNewFile();
                            }
                            FileOutputStream os = new FileOutputStream(out);
                            a.extractFile(fh, os);
                            os.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    fh = a.nextFileHeader();
                }
                a.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
