package com.example.adithyaiyer.saved;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class customer {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email_id")
    @Expose
    private String email_id;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;

    @SerializedName("email_id_friend_1")
    @Expose
    private String email_id_friend_1;

    @SerializedName("email_id_friend_2")
    @Expose
    private String email_id_friend_2;

    @SerializedName("email_id_friend_3")
    @Expose
    private String email_id_friend_3;

    @SerializedName("blood_group")
    @Expose
    private String blood_group;

    @SerializedName("medical_history")
    @Expose
    private String medical_history;

    @SerializedName("disasterIn")
    @Expose
    private Integer disasterIn;

    @SerializedName("isPersonInTrouble")
    @Expose
    private Boolean isPersonInTrouble;

    @SerializedName("city")
    @Expose
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public String getEmail_id_friend_1() {
        return email_id_friend_1;
    }

    public String getEmail_id_friend_2() {
        return email_id_friend_2;
    }

    public String getEmail_id_friend_3() {
        return email_id_friend_3;
    }

    public Boolean getPersonInTrouble() {
        return isPersonInTrouble;
    }

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getDisasterIn() {
        return disasterIn;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public void setDisasterIn(Integer disasterIn) {
        this.disasterIn = disasterIn;
    }

    public void setEmail_id_friend_1(String email_id_friend_1) {
        this.email_id_friend_1 = email_id_friend_1;
    }

    public void setEmail_id_friend_2(String email_id_friend_2) {
        this.email_id_friend_2 = email_id_friend_2;
    }

    public void setEmail_id_friend_3(String email_id_friend_3) {
        this.email_id_friend_3 = email_id_friend_3;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPersonInTrouble(Boolean personInTrouble) {
        isPersonInTrouble = personInTrouble;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public customer(String usernam,String Email,String phone, String id1,String id2,String id3,String bg, String com,String cityy){
        username=usernam;
        email_id=Email;
        phoneNumber=phone;
        email_id_friend_1=id1;
        email_id_friend_2=id2;
        email_id_friend_3=id3;
        blood_group=bg;
        medical_history=com;
        city = cityy;

    }
}
