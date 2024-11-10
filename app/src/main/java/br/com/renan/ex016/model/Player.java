package br.com.renan.ex016.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;

public class Player {

    private int id;
    private String name;
    private LocalDate birthDate;
    private float height;
    private float weight;
    private Team team;

    public Player(int id, String name, LocalDate birthDate, float height, float weight, Team team) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.team = team;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @NonNull
    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + name + '\'' +
                ", nascimento=" + birthDate +
                ", altura=" + height +
                ", peso=" + weight +
                ", time=" + ((team != null) ? team.getName() : "Sem");
    }
}
