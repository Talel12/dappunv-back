package tn.enig.DappUnv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String lieu;
    @JsonIgnore
    @OneToMany
    private List<Student> etudiants;
    @OneToOne
    private Director directeur;


    public University() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<Student> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Student> etudiants) {
        this.etudiants = etudiants;
    }

    public Director getDirecteurs() {
        return directeur;
    }

    public void setDirecteurs(Director directeur) {
        this.directeur = directeur;
    }
}
