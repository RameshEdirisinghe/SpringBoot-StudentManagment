package edu.icet.repository;

import edu.icet.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<LoginEntity,Integer> {
}
