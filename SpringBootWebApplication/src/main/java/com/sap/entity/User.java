package com.sap.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document
public class User {
    @Id
    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String>  userSettings   =   new HashMap<>();

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public User setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Map<String, String> getUserSettings() {
        return userSettings;
    }

    public User setUserSettings(Map<String, String> userSettings) {
        this.userSettings = userSettings;
        return this;
    }
}
