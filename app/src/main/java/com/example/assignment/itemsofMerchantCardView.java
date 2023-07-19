package com.example.assignment;

public class itemsofMerchantCardView {


    String name;
    String address;
    String distance;
    int callImage,locationImage,contactImage;
    String description;
    int profileImage;
    int distanceofstudent;

    public itemsofMerchantCardView(String name, String address, String distance, String description, int profileImage, int distanceofstudent,int callImage,int locationImage,int contactImage) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.callImage=callImage;
        this.locationImage=locationImage;
        this.contactImage=contactImage;
        this.description = description;
        this.profileImage = profileImage;
        this.distanceofstudent = distanceofstudent;
    }
}

