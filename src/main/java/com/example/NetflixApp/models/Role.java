package com.example.NetflixApp.models;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("Administrator"),
    CLIENT("Client");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
