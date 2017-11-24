package com.example.android.computerstoreapp.appenum;

public enum UserType {
    ADMIN(1), CUSTOMER(2);

    private int type;

    private UserType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
