package tn.enig.DappUnv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OffreType type;

    private String title;
    private String description;
    private String location;
    private double salary; // If applicable, change the type accordingly

    // ManyToOne relationship with Employer
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    // List of students who have applied to this offer
    @ManyToMany(mappedBy = "appliedOffres")
    private List<Student> applicants;

    // Other fields as needed

    public Offre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffreType getType() {
        return type;
    }

    public void setType(OffreType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Student> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Student> applicants) {
        this.applicants = applicants;
    }

    // Implement getters and setters for other fields
}
