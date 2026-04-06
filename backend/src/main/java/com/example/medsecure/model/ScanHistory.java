package com.example.medsecure.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scan_history")
public class ScanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"scanHistory", "password", "email"})  // avoids circular reference & hides sensitive fields
    private User user;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @Column(name = "search_query", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'N/A'")
    private String searchQuery = "N/A";

    @Column(name = "search_type", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'manual'")
    private String searchType = "manual";

    @Column(name = "scan_result", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'unknown'")
    private String scanResult = "unknown";

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "scanned_at")
    private LocalDateTime scannedAt;

    public ScanHistory() {
        this.scannedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Medicine getMedicine() { return medicine; }
    public void setMedicine(Medicine medicine) { this.medicine = medicine; }

    public String getSearchQuery() { return searchQuery; }
    public void setSearchQuery(String searchQuery) { 
        this.searchQuery = (searchQuery == null || searchQuery.trim().isEmpty()) ? "N/A" : searchQuery;
    }

    public String getSearchType() { return searchType; }
    public void setSearchType(String searchType) {
        this.searchType = (searchType == null || searchType.trim().isEmpty()) ? "manual" : searchType;
    }

    public String getScanResult() { return scanResult; }
    public void setScanResult(String scanResult) {
        this.scanResult = (scanResult == null || scanResult.trim().isEmpty()) ? "unknown" : scanResult;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getScannedAt() { return scannedAt; }
    public void setScannedAt(LocalDateTime scannedAt) { this.scannedAt = scannedAt; }
}