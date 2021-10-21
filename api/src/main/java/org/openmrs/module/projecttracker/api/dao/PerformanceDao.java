/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.projecttracker.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tony
 */

public class PerformanceDao {
	
	public List<Map<String, String>> getAllPerformance() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        List<Map<String, String>> allPerformance = new ArrayList<>();

        try {
            
                con = Database.connectionPool.getConnection();
                
                
                String query = "SELECT performance.performance_id, performance.patient_id, performance.description, person_name.given_name AS first_name, person_name.family_name AS surname FROM performance "
                        + " JOIN person_name ON person_name.person_id=performance.patient_id"
                        + " where person.voided=0 LIMIT 100";
                // int i = 1;
                stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(); // executUpdate() to add, update and delete
                while (rs.next()) {
                    Map<String,String> tempMap = new HashMap<>();
                    tempMap.put("patient_id", rs.getString("patient_id"));
                    tempMap.put("performance_id", rs.getString("performance_id"));
                    tempMap.put("description", rs.getString("description"));
                    tempMap.put("first_name", rs.getString("first_name"));
                    tempMap.put("family_name", rs.getString("family_name"));
                    allPerformance.add(tempMap);
                }
                return allPerformance;

        }
        catch (SQLException ex) {
                Database.handleException(ex);
                return null;
        }
        finally {
                Database.cleanUp(rs, stmt, con);
        }
    }
}
