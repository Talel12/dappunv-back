package tn.enig.DappUnv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.enig.DappUnv.model.*;
import tn.enig.DappUnv.repository.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class DappController {
    @Autowired
    IUniversity universityRepo;
    @Autowired
    IStudent studentRepo;
    @Autowired
    IDiploma diplomaRepo;
    @Autowired
    IDirector directorRepo;
    @Autowired
    IEmployer employerRepo;
    @Autowired
     IOffre offreRepo;



    public void setUniversityRepo(IUniversity dao) {
        this.universityRepo=dao;
    }

    public void setStudentRepo(IStudent dao) {
        this.studentRepo=dao;
    }

    public void setDiplomaRepo(IDiploma dao) {
        this.diplomaRepo=dao;
    }

    public void setDirectorRepo(IDirector dao) {
        this.directorRepo=dao;
    }

    public void setEmployerRepo(IEmployer dao) {
        this.employerRepo=dao;
    }

    //General Purpose

    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'etudiant', 'employeur')")
    @GetMapping("/students")
    List<Student> getAllStudentsWithDiplomas() {
        return studentRepo.findAllWithDiplomas();
    }
    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'etudiant', 'employeur')")
    @GetMapping("/universities")
    List<University> getAllUniversities(){
        return universityRepo.findAll();
    }

    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'etudiant', 'employeur')")
    @GetMapping("/diplomas")
    List<Diploma> getAllDiplomas(){
        return diplomaRepo.findAll();
    }

    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'etudiant', 'employeur')")
    @GetMapping("/directors")
    List<Director> getAllDirectors(){
        return directorRepo.findAll();
    }

    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'etudiant', 'employeur')")
    @GetMapping("/employers")
    List<Employer> getAllEmployers(){
        return employerRepo.findAll();
    }


    //Student Operations
    @PreAuthorize("hasAnyAuthority('admin', 'directeur')")
    @GetMapping("/student/delete/{id}")
    ResponseEntity deleteStudent(@PathVariable Long id){
        try {
            studentRepo.delete(studentRepo.findById(id).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAnyAuthority('admin', 'directeur')")
    @PostMapping("/student/add")
    ResponseEntity addStudent(@RequestBody Student student){
        try {
            studentRepo.save(student);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur')")
    @GetMapping("/student/{id}")
    Student readStudent(@PathVariable Long id){
        try {
            return studentRepo.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }
    //University Operations
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/university/add")
    ResponseEntity addUniversity(@RequestBody University university){
        try {
            universityRepo.save(university);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/university/delete/{id}")
    ResponseEntity deleteUniversity(@PathVariable Long id){
        try {
            universityRepo.delete(universityRepo.findById(id).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/university/{id}")
    University readUniversity(@PathVariable Long id){
        try {
            return universityRepo.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }
    //Director Operations
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/director/add")
    ResponseEntity addDirector(@RequestBody Director director){
        try {
            directorRepo.save(director);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/director/delete/{id}")
    ResponseEntity deleteDirector(@PathVariable Long id){
        try {
            directorRepo.delete(directorRepo.findById(id).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/director/{id}")
    Director readDirector(@PathVariable Long id){
        try {
            return directorRepo.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }
    //Employer Operations
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/employer/add")
    ResponseEntity addEmployer(@RequestBody Employer employer){
        try {
            employerRepo.save(employer);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/employer/delete/{id}")
    ResponseEntity deleteEmployer(@PathVariable Long id){
        try {
            employerRepo.delete(employerRepo.findById(id).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur')")
    @GetMapping("/employer/{id}")
    Employer readEmployer(@PathVariable Long id){
        try {
            return employerRepo.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }
    //Diplomas Operations
    @PreAuthorize("hasAnyAuthority('admin', 'directeur')")
    @PostMapping("/diploma/add")
    ResponseEntity addDiploma(@RequestBody Diploma diploma){
        try {
            Diploma savedDiploma = diplomaRepo.save(diploma);
            return ResponseEntity.ok(savedDiploma);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasAnyAuthority('admin', 'directeur')")
    @GetMapping("/diploma/delete/{id}")
    ResponseEntity deleteDiploma(@PathVariable Long id){
        try {
            diplomaRepo.delete(diplomaRepo.findById(id).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/diploma/{id}")
    Diploma readDiploma(@PathVariable Long id){
        try {
            return diplomaRepo.findById(id).get();
        } catch (Exception e){
            return null;
        }
    }

    @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur','etudiant')")
    @GetMapping("/offres")  // Changed the mapping to avoid conflicts with other mappings
    public List<Offre> getAllOffres() {
        return offreRepo.findAll();
    }

    // @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur')")
    @GetMapping("/offres/{id}")  // Changed the mapping to avoid conflicts with other mappings
    public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
        Offre offre = offreRepo.findById(id).orElse(null);
        if (offre != null) {
            return ResponseEntity.ok(offre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAuthority('employeur')")
    @PostMapping("/offres/add")  // Changed the mapping to avoid conflicts with other mappings
    public ResponseEntity<String> addOffre(@RequestBody Offre offre) {
        try {
            offreRepo.save(offre);
            return ResponseEntity.ok("Offre added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add offre");
        }
    }
}
