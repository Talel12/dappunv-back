package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.Offre;

@Repository
public interface IOffre extends JpaRepository<Offre, Long> {
    // You can add custom queries or methods here if needed
}
