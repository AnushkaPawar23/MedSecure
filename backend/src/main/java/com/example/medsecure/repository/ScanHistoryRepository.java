package com.example.medsecure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medsecure.model.ScanHistory;

public interface ScanHistoryRepository extends JpaRepository<ScanHistory, Long> {
    List<ScanHistory> findByUserIdOrderByScannedAtDesc(Long userId);
}