package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.Director;

@Repository
public interface IAdmin extends JpaRepository<Director, Long> {
}
