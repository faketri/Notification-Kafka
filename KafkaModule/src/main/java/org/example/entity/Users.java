package org.example.entity;

import java.io.Serializable;
import java.util.UUID;

public class Users implements Serializable {

    private UUID id;
    private String login;

    public Users() {
    }

    public Users(UUID id, String login) {
        this.id = id;
        this.login = login;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
