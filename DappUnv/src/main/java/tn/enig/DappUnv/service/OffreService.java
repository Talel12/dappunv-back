// package tn.enig.DappUnv.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import tn.enig.DappUnv.model.Offre;
// import tn.enig.DappUnv.repository.IOffre;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class OffreService {
//     private final IOffre offreRepository;

//     @Autowired
//     public OffreService(IOffre offreRepository) {
//         this.offreRepository = offreRepository;
//     }

//     public List<Offre> getAllOffres() {
//         return offreRepository.findAll();
//     }

//     public Offre getOffreById(Long id) {
//         return offreRepository.findById(id).orElse(null);
//     }

//     public void addOffre(Offre offre) {
//         offreRepository.save(offre);
//     }

//     // Add other methods as needed
// }
