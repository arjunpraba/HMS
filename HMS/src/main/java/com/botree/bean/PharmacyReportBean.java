package com.botree.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.dao.PharmacyReportDao;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;



@Component
@Scope("session")
public class PharmacyReportBean {

    @Autowired
    private PharmacyReportDao dao;

    private List<Object[]> results;

    public void loadCurrentStock() {
        results = dao.currentStock();
    }

    public List<Object[]> getResults() {
        return results;
    }
    public void setResults(List<Object[]> results) {
        this.results = results;
    }
}
