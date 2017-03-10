package com.yunfang.dms.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Lthui on 2017/3/6.
 */
public class FileUtil {
    public static void DownloadFileFromNet(String url,String fileName, HttpServletResponse response){
        DataInputStream in=null;
        OutputStream out =null;
        try{
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            in = new DataInputStream(connection.getInputStream());
            response.setContentType("application/octet-stream");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
            out.flush();
            out.close();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
