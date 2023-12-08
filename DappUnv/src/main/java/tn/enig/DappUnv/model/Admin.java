package tn.enig.DappUnv.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    private User AdminAccount;

    public Admin(){}
    public Admin(Long id, String nom, String prenom, User adminAccount) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        AdminAccount = adminAccount;
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

    public User getAdminAccount() {
        return AdminAccount;
    }

    public void setAdminAccount(User adminAccount) {
        AdminAccount = adminAccount;
    }
}
