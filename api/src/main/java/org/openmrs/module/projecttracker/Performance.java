/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.projecttracker;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;

/**
 * @author Tony
 */
public class Performance extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer performanceId;
	
	private String patientId;
	
	private String description;
	
	public Integer getPerformanceId() {
		return performanceId;
	}
	
	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public Integer getId() {
		return getPerformanceId();
	}
	
	@Override
	public void setId(Integer id) {
		setPerformanceId(id);
	}
	
}
