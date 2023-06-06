package com.datascreen.demo.domain;

public class Gender {
    private String type;
    private Integer num;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "type='" + type + '\'' +
                ", num=" + num +
                '}';
    }
}
