package com.dinesh.recyclerview.java.refresh;

public class RvModel {
    int profilePic;
    String name;
    Boolean isExpanded;

    public RvModel(int profilePic, String name, Boolean isExpanded) {
        this.profilePic = profilePic;
        this.name = name;
        this.isExpanded = isExpanded;
    }

    public RvModel() {
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    @Override
    public String toString() {
        return "RvModel{" +
                "profilePic=" + profilePic +
                ", name='" + name + '\'' +
                ", isExpanded=" + isExpanded +
                '}';
    }
}