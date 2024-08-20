package tech.jamersondev.springcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.springcache.domain.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
