package tn.enig.DappUnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.enig.DappUnv.model.Student;

import java.util.List;

@Repository
public interface IStudent extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.diploma")
    List<Student> findAllWithDiplomas();
}
