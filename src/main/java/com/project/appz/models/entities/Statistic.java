package com.project.appz.models;

import java.util.Date;

public class Statistic {

    private Long id;
    private String block;
    private Date date;
    private double value1; // Example data field
    private double value2; // Example data field

    // Constructors
    public Statistic() {
    }

    public Statistic(Long id, String block, Date date, double value1, double value2) {
        this.id = id;
        this.block = block;
        this.date = date;
        this.value1 = value1;
        this.value2 = value2;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", block='" + block + '\'' +
                ", date=" + date +
                ", value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
