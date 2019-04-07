package com.hljiang.effectivejava;

public enum testEnum {
    ENUM_A("1000", "test"),
    ENUM_B("1001", "test");

    private String code;
    private String desc;

    private testEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
