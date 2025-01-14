<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Participants" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Participant</title>
</head>
<body>
    <h2>Edit Participant</h2>
    <a href="viewparticipants.jsp">Back to Participants List</a>
    <%
        Participants participant = (Participants) request.getAttribute("participant");
        if (participant != null) {
    %>
    <form action="editParticipant" method="post">
        <!-- Hidden field to send the participant ID -->
        <input type="hidden" name="pID" value="<%= participant.getpID() %>" />

        Name: <br>
        <input type="text" name="name" value="<%= participant.getName() %>" required /><br>

        Email: <br>
        <input type="email" name="email" value="<%= participant.getEmail() %>" required /><br>

        Phone: <br>
        <input type="text" name="phone" value="<%= participant.getPhone() %>" required /><br>

        Gender: <br>
        <input type="text" name="gender" value="<%= participant.getGender() %>" required /><br>

        Batch ID: <br>
        <input type="number" name="batchID" value="<%= participant.getBatchID() %>" required /><br>

        <input type="submit" value="Update" />
    </form>
    <%
        } else {
    %>
    <p style="color: red;">Participant data is unavailable. Please try again.</p>
    <%
        }
    %>
</body>
</html>
