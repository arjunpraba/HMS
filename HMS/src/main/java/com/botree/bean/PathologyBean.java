package com.botree.bean;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.dao.PathologyDao;
import com.botree.model.PathologyReport;
import com.botree.model.Patient;

@Component
@Scope("session")
public class PathologyBean{

    @Autowired
    PathologyDao pd;

    private PathologyReport report = new PathologyReport();
    private List<PathologyReport> reports;
    private Patient patient;

    public void save() {
        report.setReportDate(LocalDate.now());
        report.setStatus("COMPLETED");
        pd.saveReport(report);
    }

    public void loadReports() {
        reports = pd.getReports(patient);
    }

    // getters & setters
}
