package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.University;

@Repository
public interface IUniversity extends JpaRepository<University, Long> {
}
