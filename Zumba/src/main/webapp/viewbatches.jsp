<%@page import="java.util.List"%>
<%@page import="model.Batches"%>
<%@page import="database.BatchesDatabase"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Batches</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h2>Batches</h2>
        </div>

        <!-- Back to Home Button -->
        <div class="mb-3">
            <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
        </div>

        <!-- Display success or error messages -->
        <%
            String message = (String) request.getAttribute("message");
            String error = (String) request.getAttribute("error");
            if (message != null) {
        %>
            <div class="alert alert-success" role="alert"><%= message %></div>
        <%
            } else if (error != null) {
        %>
            <div class="alert alert-danger" role="alert"><%= error %></div>
        <%
            }
        %>

        <!-- Batches Table -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Batch ID</th>
                    <th>Name</th>
                    <th>Day</th>
                    <th>Time of Day</th>
                    <th>Max Size of Batch</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    BatchesDatabase db = new BatchesDatabase();
                    List<Batches> batchesList = db.getBatches();
                    for (Batches batch : batchesList) {
                %>
                <tr>
                    <td><%= batch.getBatchID() %></td>
                    <td><%= batch.getName() %></td>
                    <td><%= batch.getDay() %></td>
                    <td><%= batch.getTimeOfDay() %></td>    
                    <td><%= batch.getMaxSize() %></td>
                    <td><%= batch.getStartDate() %></td>
                    <td><%= batch.getEndDate() %></td>
                    <td>
                        <a href="editBatch?BatchID=<%= batch.getBatchID() %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteBatch?BatchID=<%= batch.getBatchID() %>" 
                           class="btn btn-danger btn-sm" 
                           onclick="return confirm('Are you sure you want to delete this batch?');">
                            Delete
                        </a>
                        
                        <a href="searchparticipants.jsp?batchID=<%= batch.getBatchID() %>" class="btn btn-info btn-sm">Search Participants in this Batch</a>
                    </td>
                </tr>
                
                
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS (optional, for interactive components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
