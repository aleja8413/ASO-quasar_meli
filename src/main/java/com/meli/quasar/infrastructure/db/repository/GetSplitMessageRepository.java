package com.meli.quasar.infrastructure.db.repository;

import com.meli.quasar.infrastructure.db.entity.SatelliteDboEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetSplitMessageRepository extends JpaRepository<SatelliteDboEntity, Long> {
}
