package site.ilemon.springbootrestful.model;

import javax.security.auth.login.Configuration;

public class Contact {
    private String type;
    private int number;

    public Contact() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}