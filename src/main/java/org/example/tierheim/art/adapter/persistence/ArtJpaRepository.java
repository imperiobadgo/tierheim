package org.example.tierheim.art.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ArtJpaRepository extends JpaRepository<ArtJpa, UUID> {
}
