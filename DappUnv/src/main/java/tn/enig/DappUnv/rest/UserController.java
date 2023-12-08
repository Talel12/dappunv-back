package tn.enig.DappUnv.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.enig.DappUnv.model.*;
import tn.enig.DappUnv.repository.*;
import tn.enig.DappUnv.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    IStudent studentRepo;
    @Autowired
    IDirector directorRepo;
    @Autowired
    IEmployer employerRepo;
    @Autowired
    IUser userRepo;
    @Autowired
    IRole roleRepo;




    public void setStudentRepo(IStudent dao) {
        this.studentRepo = dao;
    }

    public void setDirectorRepo(IDirector dao) {
        this.directorRepo = dao;
    }

    public void setEmployerRepo(IEmployer dao) {
        this.employerRepo = dao;
    }

    public void setUserRepo(IUser dao) {
        this.userRepo = dao;
    }

    public void setRoleRepo(IRole dao) {
        this.roleRepo = dao;
    }

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //SignUp
    @PreAuthorize("hasAnyAuthority('admin', 'etudiant')")
    @PostMapping("/create-account/student/{id}")
    ResponseEntity createStudentAccount(@RequestBody User user, @PathVariable Long id) {
        Student student;
        try {
            student = studentRepo.findById(id).get();
            if (student.getStudentAccount() != null) ResponseEntity.badRequest().body("STUDENT_ALREADY_SIGNED_UP");
            if (userService.userExists(user)) return ResponseEntity.badRequest().body("USERNAME_TAKEN");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("STUDENT_NOT_FOUND");
        }
        List roles = new ArrayList<Role>();
        roles.add(roleRepo.findById(1));
        user.setRoles(roles);
        userService.registerUser(user);
        student.setStudentAccount(user);
        studentRepo.save(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('admin', 'employeur')")
    @PostMapping("/create-account/employer/{id}")
    ResponseEntity createEmployerAccount(@RequestBody User user, @PathVariable Long id) {
        Employer employer;
        try {
            employer = employerRepo.findById(id).get();
            if (employer.getEmployerAccount() != null) ResponseEntity.badRequest().body("EMPLOYER_ALREADY_SIGNED_UP");
            if (userService.userExists(user)) return ResponseEntity.badRequest().body("USERNAME_TAKEN");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("EMPLOYER_NOT_FOUND");
        }
        List roles = new ArrayList<Role>();
        roles.add(roleRepo.findById(4));
        user.setRoles(roles);
        userService.registerUser(user);
        employer.setEmployerAccount(user);
        employerRepo.save(employer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('admin', 'directeur')")
    @PostMapping("/create-account/director/{id}")
    ResponseEntity createDirectorAccount(@RequestBody User user, @PathVariable Long id) {
        Director director;
        try {
            director = directorRepo.findById(id).get();
            if (director.getDirectorAccount() != null) ResponseEntity.badRequest().body("DIRECTOR_ALREADY_SIGNED_UP");
            if (userService.userExists(user)) return ResponseEntity.badRequest().body("USERNAME_TAKEN");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("DIRECTOR_NOT_FOUND");
        }
        List roles = new ArrayList<Role>();
        roles.add(roleRepo.findById(2));
        user.setRoles(roles);
        userService.registerUser(user);
        director.setDirectorAccount(user);
        directorRepo.save(director);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity login(@RequestBody User user) {
        AuthToken token = userService.authenticateUser(user);
        if (token != null) return ResponseEntity.ok(token);
        return ResponseEntity.badRequest().body("BAD_CREDENTIALS");
    }
}





