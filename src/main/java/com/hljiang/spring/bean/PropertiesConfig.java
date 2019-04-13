package com.hljiang.spring.bean;

public class PropertiesConfig {

    private String testValue;

    private String testValue2ForOverride;

    private String valueNoAnnotate;

    private String valueNoAnnotateForDefault;

    private String placeHolders;

    public String getPlaceHolders() {
        return placeHolders;
    }

    public void setPlaceHolders(String placeHolders) {
        this.placeHolders = placeHolders;
    }

    public String getValueNoAnnotate() {
        return valueNoAnnotate;
    }

    public void setValueNoAnnotate(String valueNoAnnotate) {
        this.valueNoAnnotate = valueNoAnnotate;
    }

    public String getValueNoAnnotateForDefault() {
        return valueNoAnnotateForDefault;
    }

    public void setValueNoAnnotateForDefault(String valueNoAnnotateForDefault) {
        this.valueNoAnnotateForDefault = valueNoAnnotateForDefault;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getTestValue2ForOverride() {
        return testValue2ForOverride;
    }

    public void setTestValue2ForOverride(String testValue2ForOverride) {
        this.testValue2ForOverride = testValue2ForOverride;
    }
}
