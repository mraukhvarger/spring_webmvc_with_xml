package com.raukhvarger.spring_first;

import java.util.List;

public class MyBean {
    private Integer value;

    private List<Integer> integerList;

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MyBean() {
        this.value = 0;
    }
}
