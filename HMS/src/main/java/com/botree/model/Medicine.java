package com.botree.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;

    private String name;
    private int availableQty;

    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAvailableQty() {
        return availableQty;
    }
    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }
}
