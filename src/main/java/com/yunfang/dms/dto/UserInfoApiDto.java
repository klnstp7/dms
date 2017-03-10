package com.yunfang.dms.dto;

/**
 * 接口返回的用户信息
 * Created by Administrator on 2017/2/17.
 */
public class UserInfoApiDto {
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIsSuperUser() {
        return isSuperUser;
    }

    public void setIsSuperUser(Integer isSuperUser) {
        this.isSuperUser = isSuperUser;
    }

    private String loginName;

    private Integer companyId;

    private String companyName;

    private Integer isSuperUser;

    public Integer getLoginAccountId() {
        return loginAccountId;
    }

    public void setLoginAccountId(Integer loginAccountId) {
        this.loginAccountId = loginAccountId;
    }

    private Integer loginAccountId;
}
