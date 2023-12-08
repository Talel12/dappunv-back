package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.Employer;

@Repository
public interface IEmployer extends JpaRepository<Employer, Long> {
}
