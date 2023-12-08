// package tn.enig.DappUnv.rest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.*;
// import tn.enig.DappUnv.model.Offre;
// import tn.enig.DappUnv.repository.*;
// // import tn.enig.DappUnv.service.OffreService;

// import java.util.List;

// @RestController
// @RequestMapping(value = "/api/offres", produces = "application/json")
// public class OffreController {
    
//     @Autowired
//     private IOffre offreRepository;

//     // @Autowired
//     // public void OffreService(IOffre offreRepository) {
//     //     this.offreRepository = offreRepository;
//     // }

//     // @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur',)")
//     @GetMapping
//     public List<Offre> getAllOffres() {
//         return offreRepository.findAll();
//     }

//     // @PreAuthorize("hasAnyAuthority('admin', 'directeur', 'employeur')")
//     @GetMapping("/{id}")
//     public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
//         Offre offre = offreRepository.findById(id).orElse(null);
//         if (offre != null) {
//             return ResponseEntity.ok(offre);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PreAuthorize("hasAuthority('employeur')")
//     @PostMapping("/add")
//     public ResponseEntity<String> addOffre(@RequestBody Offre offre) {
//         try {
//             offreRepository.save(offre);
//             return ResponseEntity.ok("Offre added successfully");
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body("Failed to add offre");
//         }
//     }

//     // Add other CRUD operations or custom queries as needed
// }
