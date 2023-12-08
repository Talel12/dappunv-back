package tn.enig.DappUnv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String phoneNumber;
    private boolean b2Francais;
    private boolean b2Anglais;
    private double moyenne;
    private boolean stageValide;
    private boolean admis;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    private User studentAccount;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("student")
    private Diploma diploma;

    public Student() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(User studentAccount) {
        this.studentAccount = studentAccount;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public boolean isB2Francais() {
        return b2Francais;
    }

    public void setB2Francais(boolean b2Francais) {
        this.b2Francais = b2Francais;
    }

    public boolean isB2Anglais() {
        return b2Anglais;
    }

    public void setB2Anglais(boolean b2Anglais) {
        this.b2Anglais = b2Anglais;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public boolean isStageValide() {
        return stageValide;
    }

    public void setStageValide(boolean stageValide) {
        this.stageValide = stageValide;
    }

    public boolean isAdmis() {
        return admis;
    }

    public void setAdmis(boolean admis) {
        this.admis = admis;
    }
}
