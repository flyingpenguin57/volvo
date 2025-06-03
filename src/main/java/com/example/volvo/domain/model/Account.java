package com.example.volvo.domain.model;

import com.example.volvo.utils.HashUtil;

public class Account {
    private long id;
    private String email;
    private String username;
    private int active;

    public static Account createNewAccount(String email, String username) {
        Account account = new Account();
        account.setEmail(email);
        account.setUsername(username);
        return account;
    }

    public static String getContractIdFromEmail(String email) {
       return HashUtil.hashWithGuava(email);
    }


    public Account() {}

    public Account(long id, String email, String username, int active) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
