package com.project.anypost.models;

import com.project.anypost.domain.User;

public class UserModel {
    Long id;
    String name;

    public static UserModel toModel(User user){
        UserModel model = new UserModel();
        model.setName(user.getName());
        model.setId(user.getId());
        return model;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
