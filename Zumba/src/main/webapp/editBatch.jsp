<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Batches" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Batch</title>
</head>
<body>
    <h2>Edit a Batch</h2>
    <a href="viewbatches.jsp">Back to Batches List</a>
    <%
        Batches batch = (Batches) request.getAttribute("batch");
        if (batch != null) {
    %>
    <form action="editBatch" method="post">
        <!-- Hidden field to send the BatchID -->
        <input type="hidden" name="BatchID" value="<%= batch.getBatchID() %>" />

        Name: <br>
        <input type="text" name="name" value="<%= batch.getName() %>" required /><br>

        Day: <br>
        <input type="text" name="day" value="<%= batch.getDay() %>" required /><br>

        Time of Day: <br>
        <input type="text" name="timeOfDay" value="<%= batch.getTimeOfDay() %>" required /><br>

        Max Size of Batch: <br>
        <input type="text" name="maxSize" value="<%= batch.getMaxSize() %>" required /><br>

        Start Date: <br>
        <input type="date" name="startDate" value="<%= batch.getStartDate().toString() %>" required /><br>
        
        End Date: <br>
        <input type="date" name="endDate" value="<%= batch.getEndDate().toString() %>" required /><br>

        <input type="submit" value="Update" />
    </form>
    <%
        } else {
    %>
    <p style="color: red;">Batch data is unavailable. Please try again.</p>
    <%
        }
    %>
</body>
</html>
