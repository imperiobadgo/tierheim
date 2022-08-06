package org.example.tierheim.mitarbeiter.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface MitarbeiterJpaRepository extends JpaRepository<MitarbeiterJpa, UUID> {
}
