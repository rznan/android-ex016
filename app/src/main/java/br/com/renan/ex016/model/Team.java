package br.com.renan.ex016.model;

import androidx.annotation.NonNull;

/**
 * @author: renan santos carvalho
 */
public class Team {
    private int code;
    private String name;
    private String city;

    public Team(int code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    public Team() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NonNull
    @Override
    public String toString() {
        return  "codigo=" + code +
                ", nome='" + name + '\'' +
                ", cidade='" + city + '\'';
    }
}
