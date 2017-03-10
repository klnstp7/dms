package com.yunfang.dms.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yunfang.dms.dto.UserInfoApiDto;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/2/17.
 */
public class UserInfoUtil {
    /*
    * 获取当前用户信息
    * */
    public static UserInfoApiDto getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String json = CookiesUtil.getCookieByName(request, "DmsUserInfo").getValue();
            json = URLDecoder.decode(json, "utf-8");
            Gson gs = new Gson();
            UserInfoApiDto dto = gs.fromJson(json, UserInfoApiDto.class);
            return dto;
        }
        catch (UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    /*
    * 根据用户名获取用户信息
    * */
    public static UserInfoApiDto getCurrentUser(String userAccount)
    {
        Properties properties = ReadPropertiesData.readPropertie("config");
        String url = properties.get("permissionurl").toString() + "/account/" + userAccount;
        String result = URLtoJSONandXML.getHttpUrl_new(url, "UTF-8");
        Gson gson=new Gson();
        Map<String, Object> retMap = gson.fromJson(result, new TypeToken<Map<String, Object>>() {
        }.getType());
        UserInfoApiDto dto = gson.fromJson(gson.toJson(retMap.get("data")), UserInfoApiDto.class);
        return dto;
    }

    /*
    * 获取当前用户所在的公司/部门
    * */
    public static Integer getCurrentUserCompanyId(String userAccount) {
        return getCurrentUser(userAccount).getCompanyId();
    }

    /*
    * 获取当前用户所在的公司/部门
    * */
    public static Integer getCurrentUserCompanyId() {
        return getCurrentUser().getCompanyId();
    }
}
