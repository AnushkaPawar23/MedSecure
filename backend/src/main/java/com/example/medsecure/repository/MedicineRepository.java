package com.example.medsecure.repository;

import com.example.medsecure.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByNameContainingIgnoreCase(String name);
    Optional<Medicine> findByBatchNum(String batchNum);
    Optional<Medicine> findByBarcode(String barcode);
}