package org.akov.agence.repository;

import org.akov.agence.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // You can define custom query methods here if needed
}
