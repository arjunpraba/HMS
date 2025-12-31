package com.botree.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pathology_test")
public class PathologyTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    private String testName;
    private String normalRange;
    private Double cost;
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getNormalRange() {
		return normalRange;
	}
	public void setNormalRange(String normalRange) {
		this.normalRange = normalRange;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public PathologyTest(String testName, String normalRange, Double cost) {
		super();
		this.testName = testName;
		this.normalRange = normalRange;
		this.cost = cost;
	}
	public PathologyTest() {
	
		// TODO Auto-generated constructor stub
	}

    
    // getters & setters
}
