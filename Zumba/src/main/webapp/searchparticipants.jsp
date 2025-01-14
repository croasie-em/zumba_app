<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Participants" %>
<%@ page import="database.ParticipantsDatabase" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Participants in Batch</title>
</head>
<body>
    <h2>Participants in Batch</h2>

    <% 
        // Get the batchID from the query parameter
        String batchIDStr = request.getParameter("batchID");

        if (batchIDStr != null && !batchIDStr.isEmpty()) {
            try {
                int batchID = Integer.parseInt(batchIDStr);

                // Fetch the list of participants for the given batchID
                ParticipantsDatabase db = new ParticipantsDatabase();
                ArrayList<Participants> participantsList = db.getParticipantsByBatch(batchID);

                if (participantsList != null && !participantsList.isEmpty()) {
    %>

                    <table border="1">
                        <tr>
                            <th>Participant ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Gender</th>
                        </tr>
                        
                        <% 
                            for (Participants participant : participantsList) {
                        %>
                            <tr>
                                <td><%= participant.getpID() %></td>
                                <td><%= participant.getName() %></td>
                                <td><%= participant.getEmail() %></td>
                                <td><%= participant.getPhone() %></td>
                                <td><%= participant.getGender() %></td>
                            </tr>
                        <% 
                            }
                        %>
                    </table>

                <% 
                } else {
                %>
                    <p>No participants found for this batch.</p>
                <% 
                }
            } catch (NumberFormatException e) {
                // In case of invalid batchID parameter
                out.println("<p style='color: red;'>Invalid Batch ID.</p>");
            }
        } else {
            out.println("<p style='color: red;'>No Batch ID provided.</p>");
        }
    %>

    <br>
    <a href="viewbatches.jsp">Back to Batches List</a>
    <a href="viewparticipants.jsp">Back to Participants List</a>
</body>
</html>