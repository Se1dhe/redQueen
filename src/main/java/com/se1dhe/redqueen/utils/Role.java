package com.se1dhe.redqueen.utils;

public enum Role {
    USER(0), VIP(1), MODERATOR(5), ADMIN(10), CREATOR(100), BANNED(-1);

    private final int role;

    Role(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }







}
