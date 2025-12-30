package com.botree.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.botree.model.PathologyReport;
import com.botree.model.Patient;

@Repository
public class PathologyDao {
@Autowired
SessionFactory sf;

public void saveReport(PathologyReport report) {
	// TODO Auto-generated method stub
	
}

public List<PathologyReport> getReports(Patient patient) {
	// TODO Auto-generated method stub
	return null;
}
	
}
