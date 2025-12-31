package com.botree.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.botree.dao.PharmacyDao;
import com.botree.model.Prescription;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("pharmacyBean")     // ✅ JSF EL name
@ViewScoped                // ✅ JSF scope
@Component                 // ✅ Spring bean
public class PharmacyBean {

    @Autowired
    private PharmacyDao pharmacyDao;

    private int pid;
    private List<Prescription> prescriptions;

    public void search() {
        prescriptions = pharmacyDao.getPrescriptionsByPid(pid);
    }

    public void issue(Prescription prescription) {
        pharmacyDao.issueMedicine(prescription);
        FacesContext.getCurrentInstance()
            .addMessage(null,
                new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Success",
                    "Medicine Issued Successfully"
                ));
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
