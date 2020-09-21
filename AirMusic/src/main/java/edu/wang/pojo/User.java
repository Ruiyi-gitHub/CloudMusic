package edu.wang.pojo;

import org.apache.ibatis.type.Alias;

@Alias("use")
public class User {
    public User(String rAideoName, byte[] rAudio, byte[] rVoice) {
        this.rAideoName = rAideoName;
        this.rAudio = rAudio;
        this.rVoice = rVoice;
    }

    private int uid;

    private String uname;

    private String rAideoName;

    private int uage;

    private Long id;

    private byte[] rVoice;

    private byte[] rAudio;

    public byte[] getrAudio() {
        return rAudio;
    }

    public void setrAudio(byte[] rAudio) {
        this.rAudio = rAudio;
    }

    public String getrAideoName() {
        return rAideoName;
    }

    public void setrAideoName(String rAideoName) {
        this.rAideoName = rAideoName;
    }

    public byte[] getrVoice() {
        return rVoice;
    }

    public void setrVoice(byte[] rVoice) {
        this.rVoice = rVoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User() {
    }

    public User(String uname, int uage) {
        this.uname = uname;
        this.uage = uage;
    }

    public User(int uid, String uname, int uage) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }
}
