package org.example.tierheim.tier.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface TierJpaRepository extends JpaRepository<TierJpa, UUID> {
}
