package com.botree.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    private int pid;
    private int prescribedQty;
    private int issuedQty;
    private String status;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public int getPrescriptionId() {
        return prescriptionId;
    }
    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getPrescribedQty() {
        return prescribedQty;
    }
    public void setPrescribedQty(int prescribedQty) {
        this.prescribedQty = prescribedQty;
    }
    public int getIssuedQty() {
        return issuedQty;
    }
    public void setIssuedQty(int issuedQty) {
        this.issuedQty = issuedQty;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Medicine getMedicine() {
        return medicine;
    }
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
