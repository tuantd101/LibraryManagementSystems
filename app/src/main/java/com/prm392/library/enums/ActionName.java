package com.prm392.library.enums;

public enum ActionName {
    CHANGE_PASSWORD("Change Password"),
    FORGOT_PASSWORD("Forgot Password"),
    LOGIN("Login"),

    //    ORDER
    CREATE_ORDER("Create Order"),
    UPDATE_ORDER("Update Order"),
    SOFT_DELETE_ORDER("Soft Delete Order"),

    // BOOK
    CREATE_BOOK("Create Book"),
    UPDATE_BOOK("Update Book"),
    SOFT_DELETE_BOOK("Soft Delete Book"),

    // EMPLOYEE
    CREATE_EMPLOYEE("Create Employee"),
    UPDATE_EMPLOYEE("Update Employee"),
    SOFT_DELETE_EMPLOYEE("Soft Delete Employee"),

    // CUSTOMER
    CREATE_CUSTOMER("Create Customer"),
    UPDATE_CUSTOMER("Update Customer"),
    SOFT_DELETE_CUSTOMER("Soft Delete Customer");


    private final String displayName;

    ActionName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
