package com.example.hospitalrecord.controllers;

public class EmpSearchClass {
     String fname;
     String lname;
     String sexx;
     String agee;
     String connumber;
     String dateofh;
     String ema;
     String ro;
     String spec;
     String avail;
     String empi;
     String salary1;

    public EmpSearchClass(String fname, String lname, String sexx, String agee, String connumber, String dateofh, String ema, String ro, String spec, String avail, String empi, String salary1) {
        this.fname = fname;
        this.lname = lname;
        this.sexx = sexx;
        this.agee = agee;
        this.connumber = connumber;
        this.dateofh = dateofh;
        this.ema = ema;
        this.ro = ro;
        this.spec = spec;
        this.avail = avail;
        this.empi = empi;
        this.salary1 = salary1;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSexx() {
        return sexx;
    }

    public void setSexx(String sexx) {
        this.sexx = sexx;
    }

    public String getAgee() {
        return agee;
    }

    public void setAgee(String agee) {
        this.agee = agee;
    }

    public String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }

    public String getDateofh() {
        return dateofh;
    }

    public void setDateofh(String dateofh) {
        this.dateofh = dateofh;
    }

    public String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }

    public String getRo() {
        return ro;
    }

    public void setRo(String ro) {
        this.ro = ro;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getEmpi() {
        return empi;
    }

    public void setEmpi(String empi) {
        this.empi = empi;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }
}
