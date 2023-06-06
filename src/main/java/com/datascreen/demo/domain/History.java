package com.datascreen.demo.domain;

public class History {
    private String year;
    private Integer province;
    private Integer school;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "History{" +
                "year='" + year + '\'' +
                ", province=" + province +
                ", school=" + school +
                '}';
    }
}
