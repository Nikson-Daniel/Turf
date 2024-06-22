package com.theadvent.turf_dev;

public class Post {
    private int owner_id;
    private int post_id;
    private String district;
    private String address;
    private String price;
    private String name;
    private String description;
    private String timing;
    private String contact_number;
    private String link1;
    private String link2;
    private String link3;
    private String link4;
    private String link5;

    // Add getters and setters here


    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public String getLink4() {
        return link4;
    }

    public void setLink4(String link4) {
        this.link4 = link4;
    }

    public String getLink5() {
        return link5;
    }

    public void setLink5(String link5) {
        this.link5 = link5;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ownerId=" + owner_id +
                ", postId=" + post_id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timing='" + timing + '\'' +
                ", contactNumber='" + contact_number + '\'' +
                ", link1='" + link1 + '\'' +
                ", link2='" + link2 + '\'' +
                ", link3='" + link3 + '\'' +
                ", link4='" + link4 + '\'' +
                ", link5='" + link5 + '\'' +
                '}';
    }
}
