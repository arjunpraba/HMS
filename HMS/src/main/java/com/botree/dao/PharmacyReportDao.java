package com.botree.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class PharmacyReportDao {

    @Autowired
    private SessionFactory sessionFactory;

    /* Issue Sequence Report */
    public List<Object[]> issueSequence(Date from, Date to) {
        return sessionFactory.getCurrentSession()
            .createQuery(
              "select m.name, p.issuedQty " +
              "from Prescription p join p.medicine m " +
              "where p.status='ISSUED'")
            .list();
    }

    /* Current Stock Report */
    public List<Object[]> currentStock() {
        return sessionFactory.getCurrentSession()
            .createQuery("select name, availableQty from Medicine")
            .list();
    }
}
