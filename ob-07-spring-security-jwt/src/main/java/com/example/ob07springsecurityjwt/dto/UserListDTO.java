package com.example.ob07springsecurityjwt.dto;

import com.example.ob07springsecurityjwt.domain.User;

import java.util.List;

/**
 * Data transfer object
 */
public class UserListDTO {

    List<User> users;

    public UserListDTO() {}

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
