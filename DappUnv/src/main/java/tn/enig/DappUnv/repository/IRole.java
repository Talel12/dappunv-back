package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.Role;

@Repository
public interface IRole extends JpaRepository<Role, Integer> {
}
