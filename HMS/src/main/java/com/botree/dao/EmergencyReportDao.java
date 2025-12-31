package com.botree.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmergencyReportDao {

    @Autowired
    private SessionFactory sessionFactory;

    /* Patient Registered Report */
    public Object[] patientSummary(Date from, Date to) {
        return (Object[]) sessionFactory.getCurrentSession()
            .createQuery(
              "select count(*), " +
              "sum(case when gender='Male' then 1 else 0 end), " +
              "sum(case when gender='Female' then 1 else 0 end) " +
              "from Patient where regDate between :f and :t")
            .setParameter("f", from)
            .setParameter("t", to)
            .uniqueResult();
    }

    /* Registered from Each City */
    public List<Object[]> patientsByCity(Date from, Date to) {
        return sessionFactory.getCurrentSession()
            .createQuery(
              "select city, count(*) from Patient " +
              "where regDate between :f and :t group by city")
            .setParameter("f", from)
            .setParameter("t", to)
            .list();
    }
}
