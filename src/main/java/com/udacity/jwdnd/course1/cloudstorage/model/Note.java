package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {
    private Integer noteid;
    private String notetitle;
    private String notedescription;
    private  Integer userid;

    public Note(Integer noteid, String notetitle, String notedescription, Integer userid) {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }

    // get and set noteid
    public Integer getNoteid() {
        return noteid;
    }
    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    // get and set notetitle
    public String getNotetitle() {
        return notetitle;
    }
    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    // get and set notedescription
    public String getNotedescription() {
        return notedescription;
    }
    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    // get and set userid
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
