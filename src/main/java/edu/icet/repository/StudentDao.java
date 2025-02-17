package edu.icet.repository;

import edu.icet.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<StudentEntity,Integer> {
    List<StudentEntity> findByName(String name);
}
