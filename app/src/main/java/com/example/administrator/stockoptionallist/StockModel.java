package com.example.administrator.stockoptionallist;

/**
 * Created by Administrator on 2018/12/20.
 */

public class StockModel {

    private String code;
    private String name;
    private String secType;
    private String secIcon;

    public StockModel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getSecIcon() {
        return secIcon;
    }

    public void setSecIcon(String secIcon) {
        this.secIcon = secIcon;
    }
}
