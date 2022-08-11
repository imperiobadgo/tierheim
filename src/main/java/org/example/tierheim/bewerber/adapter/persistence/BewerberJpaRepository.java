package org.example.tierheim.bewerber.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface BewerberJpaRepository extends JpaRepository<BewerberJpa, UUID> {
}
