package com.example.hospitalrecord.controllers;

public class searchClass {
    String fname;
    String lname;
    String id;
    String cnumber;
    String agee;
    String sexx;
    String connumber;
    String addate;
    String adtime;
    String statuss;
    String modue;

    public searchClass(String fname, String lname, String id, String cnumber, String agee, String sexx, String connumber, String addate, String adtime, String statuss, String modue) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.cnumber = cnumber;
        this.agee = agee;
        this.sexx = sexx;
        this.connumber = connumber;
        this.addate = addate;
        this.adtime = adtime;
        this.statuss = statuss;
        this.modue = modue;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getId() {
        return id;
    }

    public String getCnumber() {
        return cnumber;
    }

    public String getAgee() {
        return agee;
    }

    public String getSexx() {
        return sexx;
    }

    public String getConnumber() {
        return connumber;
    }

    public String getAddate() {
        return addate;
    }

    public String getAdtime() {
        return adtime;
    }

    public String getStatuss() {
        return statuss;
    }

    public String getModue() {
        return modue;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public void setAgee(String agee) {
        this.agee = agee;
    }

    public void setSexx(String sexx) {
        this.sexx = sexx;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber;
    }

    public void setAddate(String addate) {
        this.addate = addate;
    }

    public void setAdtime(String adtime) {
        this.adtime = adtime;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public void setModue(String modue) {
        this.modue = modue;
    }

}
