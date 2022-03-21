package com.practice.bacd;

public class DonationList {
    public String id;
    public String name;
    public String contactNo;
    public String donationAmount;
    public String clothType;
    public DonationList(){

    }
    public DonationList(String id,  String name, String contactNo,String donationAmount,String clothType){
        this.id=id;
        this.name=name;
        this.contactNo=contactNo;
        this.donationAmount=donationAmount;
        this.clothType=clothType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(String donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }
}
