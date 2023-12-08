package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUser extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.Username = ?1")
    Optional<List<User>> findByUsername(String username);
}
