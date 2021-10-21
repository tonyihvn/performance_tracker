/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.projecttracker.fragment.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.openmrs.api.context.Context;
import org.openmrs.module.projecttracker.api.dao.Database;
import org.openmrs.module.projecttracker.api.dao.PerformanceDao;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 * @author Tony
 */
public class PerformanceFragmentController {
	
	PerformanceDao performanceDao = new PerformanceDao();
	
	public void controller(FragmentModel model) {
		
		String lastPerformanceCheck = "";
		
		Database.initConnection();
		List<Map<String, String>> allPerformance = performanceDao.getAllPerformance();
		lastPerformanceCheck = Context.getAdministrationService().getGlobalProperty("last_performance_check");
		if (lastPerformanceCheck == null) {
			lastPerformanceCheck = "1990-01-01";
		}
		
		model.addAttribute("performances", allPerformance);
		model.addAttribute("lastPerformanceCheck", lastPerformanceCheck);
	}
	
	private void savePerformance(String patientId, String Description) {
		updatePerformanceCheck();
	}
	
	public String updatePerformanceCheck() {
		
		Calendar now = Calendar.getInstance();
		
		String today = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE);
		Context.getAdministrationService().setGlobalProperty("last_performance_check", today);
		return "complete";
	}
	
}
