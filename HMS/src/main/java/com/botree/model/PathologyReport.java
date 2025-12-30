package com.botree.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "pathology_report")
public class PathologyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private PathologyTest test;

    private String resultValue;
    private LocalDate reportDate;
    private String status;
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public PathologyTest getTest() {
		return test;
	}
	public void setTest(PathologyTest test) {
		this.test = test;
	}
	public String getResultValue() {
		return resultValue;
	}
	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}
	public LocalDate getReportDate() {
		return reportDate;
	}
	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PathologyReport(Long reportId, Long patientId, PathologyTest test, String resultValue, LocalDate reportDate,
			String status) {
		super();
		this.reportId = reportId;
		this.patientId = patientId;
		this.test = test;
		this.resultValue = resultValue;
		this.reportDate = reportDate;
		this.status = status;
	}
	public PathologyReport() {
		// TODO Auto-generated constructor stub
	}

    // getters & setters
    
}
