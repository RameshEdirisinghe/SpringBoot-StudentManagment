package edu.icet.repository;

import edu.icet.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<TeacherEntity,Integer> {
}
