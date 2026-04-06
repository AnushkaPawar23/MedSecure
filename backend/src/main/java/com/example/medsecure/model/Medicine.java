package com.example.medsecure.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "batch_num")
    private String batchNum;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "ingredients", columnDefinition = "TEXT")
    private String ingredients;

    @Column(name = "uses", columnDefinition = "TEXT")
    private String uses;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "is_genuine")
    private boolean isGenuine = true;

    @Column(name = "dosage_form")
    private String dosageForm;

    @Column(name = "strength")
    private String strength;

    @Column(name = "price_range")
    private String priceRange;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "storage_instructions", columnDefinition = "TEXT")
    private String storageInstructions;

    @Column(name = "side_effects", columnDefinition = "TEXT")
    private String sideEffects;

    @Column(name = "contraindications", columnDefinition = "TEXT")
    private String contraindications;

    @Column(name = "manufacturer_license")
    private String manufacturerLicense;

    @Column(name = "verified_date")
    private String verifiedDate;

    @Column(name = "verification_agency")
    private String verificationAgency;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;          // renamed for clarity, mapped to expiry_date

    // Constructors
    public Medicine() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBatchNum() { return batchNum; }
    public void setBatchNum(String batchNum) { this.batchNum = batchNum; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getUses() { return uses; }
    public void setUses(String uses) { this.uses = uses; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public boolean isGenuine() { return isGenuine; }
    public void setGenuine(boolean genuine) { isGenuine = genuine; }

    public String getDosageForm() { return dosageForm; }
    public void setDosageForm(String dosageForm) { this.dosageForm = dosageForm; }

    public String getStrength() { return strength; }
    public void setStrength(String strength) { this.strength = strength; }

    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }

    public String getRegistrationNo() { return registrationNo; }
    public void setRegistrationNo(String registrationNo) { this.registrationNo = registrationNo; }

    public String getStorageInstructions() { return storageInstructions; }
    public void setStorageInstructions(String storageInstructions) { this.storageInstructions = storageInstructions; }

    public String getSideEffects() { return sideEffects; }
    public void setSideEffects(String sideEffects) { this.sideEffects = sideEffects; }

    public String getContraindications() { return contraindications; }
    public void setContraindications(String contraindications) { this.contraindications = contraindications; }

    public String getManufacturerLicense() { return manufacturerLicense; }
    public void setManufacturerLicense(String manufacturerLicense) { this.manufacturerLicense = manufacturerLicense; }

    public String getVerifiedDate() { return verifiedDate; }
    public void setVerifiedDate(String verifiedDate) { this.verifiedDate = verifiedDate; }

    public String getVerificationAgency() { return verificationAgency; }
    public void setVerificationAgency(String verificationAgency) { this.verificationAgency = verificationAgency; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}