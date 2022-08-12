package org.example.tierheim.reservierungen.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ReservierungJpaRepository extends JpaRepository<ReservierungJpa, UUID> {
}
