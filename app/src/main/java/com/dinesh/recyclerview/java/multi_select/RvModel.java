package com.dinesh.recyclerview.java.multi_select;

/**
 * RvModel
 */


public class RvModel {
    int profilePic;
    String name;
    Boolean isExpanded;

    public RvModel(int profilePic, String name, Boolean isExpanded) {
        this.profilePic = profilePic;
        this.name = name;
        this.isExpanded = isExpanded;
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
