
<div style="text-align: center;"><button class="btn btn-success" id="sendSMS" style="text-align: center;">Update Performance</button></div>
<hr>
<h3>Last Performance Check Date: <%=lastPerformanceCheck%></h3>
<table>
    <thead>
        <tr>
            <th>Patient ID</th><th>First Name</th><th>Last Name</th><th>Description</th><th>Performance ID</th>
        </tr>
    </thead>
    
    <tbody>
        <% for(int i=0; i<performances.size(); i++)
        { %>
           <tr>
               <td><%= performances.get(i).get("patient_id"); %></td>
               <td><%= performances.get(i).get("first_name"); %></td>
               <td><%= performances.get(i).get("family_name"); %></td>
                <td><%= performances.get(i).get("description"); %></td>
                <td><%= performances.get(i).get("performance_id"); %></td>
           </tr>
       <% } %>
    </tbody>
</table>