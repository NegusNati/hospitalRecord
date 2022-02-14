package com.example.hospitalrecord.controllers;

public class EmpSearchClass {
    static String fname;
    static String lname;
    static String sexx;
    static String agee;
    static String connumber;
    static String dateofh;
    static String ema;
    static String ro;
    static String spec;
    static String avail;
    static String empi;
    static String salary1;

    public EmpSearchClass(String fname, String lname, String sexx, String agee, String connumber, String dateofh, String ema, String ro, String spec, String avail, String empi, String salary1) {
        EmpSearchClass.fname = fname;
        EmpSearchClass.lname = lname;
        EmpSearchClass.sexx = sexx;
        EmpSearchClass.agee = agee;
        EmpSearchClass.connumber = connumber;
        EmpSearchClass.dateofh = dateofh;
        EmpSearchClass.ema = ema;
        EmpSearchClass.ro = ro;
        EmpSearchClass.spec = spec;
        EmpSearchClass.avail = avail;
        EmpSearchClass.empi = empi;
        EmpSearchClass.salary1 = salary1;
    }

    public static String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public static String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public static String getSexx() {
        return sexx;
    }

    public void setSexx(String sexx) {
        this.sexx = sexx;
    }

    public static String getAgee() {
        return agee;
    }

    public void setAgee(String agee) {
        this.agee = agee;
    }

    public static String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }

    public static String getDateofh() {
        return dateofh;
    }

    public void setDateofh(String dateofh) {
        this.dateofh = dateofh;
    }

    public static String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }

    public static String getRo() {
        return ro;
    }

    public void setRo(String ro) {
        this.ro = ro;
    }

    public static String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public static String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public static String getEmpi() {
        return empi;
    }

    public void setEmpi(String empi) {
        this.empi = empi;
    }

    public static String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }
}
