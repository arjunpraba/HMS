package com.botree.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.botree.model.Medicine;
import com.botree.model.Prescription;

@Repository
@Transactional
public class PharmacyDao {

    @Autowired
    private SessionFactory sessionFactory;

    /* Issue / Balance Medicine */
    public List<Prescription> getPrescriptionsByPid(int pid) {
        return sessionFactory.getCurrentSession()
                .createQuery(
                  "from Prescription where pid=:pid and status='PENDING'",
                  Prescription.class)
                .setParameter("pid", pid)
                .list();
    }

    public void issueMedicine(Prescription prescription) {

        prescription.setStatus("ISSUED");
        sessionFactory.getCurrentSession().update(prescription);

        Medicine medicine = prescription.getMedicine();
        medicine.setAvailableQty(
            medicine.getAvailableQty() - prescription.getIssuedQty()
        );

        sessionFactory.getCurrentSession().update(medicine);
    }
}
