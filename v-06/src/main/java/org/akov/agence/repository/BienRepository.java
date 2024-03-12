package org.akov.agence.repository;

import org.akov.agence.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Integer> {
    List<Bien> findByVisibleTrue();
}
