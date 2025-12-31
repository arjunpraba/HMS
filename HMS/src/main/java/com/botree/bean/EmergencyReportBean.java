package com.botree.bean;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.dao.EmergencyReportDao;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;



@Component
@Scope("session")
public class EmergencyReportBean {

    @Autowired
    private EmergencyReportDao dao;

    private Date fromDate;
    private Date toDate;
    private Object[] summary;
    private List<Object[]> cityWise;

    public void generate() {
        summary = dao.patientSummary(fromDate, toDate);
        cityWise = dao.patientsByCity(fromDate, toDate);
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public Object[] getSummary() {
        return summary;
    }
    public List<Object[]> getCityWise() {
        return cityWise;
    }
}
