<%@page import="java.util.List"%>
<%@page import="model.Participants"%>
<%@page import="database.ParticipantsDatabase"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Participants</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h2>Participants List</h2>
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

        <!-- Participants Table -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Participant ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>Batch ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ParticipantsDatabase db = new ParticipantsDatabase();
                    List<Participants> participantsList = db.getParticipants();
                    for (Participants participant : participantsList) {
                %>
                <tr>
                    <td><%= participant.getpID() %></td>
                    <td><%= participant.getName() %></td>
                    <td><%= participant.getEmail() %></td>
                    <td><%= participant.getPhone() %></td>
                    <td><%= participant.getGender() %></td>
                    <td><%= participant.getBatchID() %></td>
                    <td>
                        <a href="editParticipant?pID=<%= participant.getpID() %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="deleteParticipant?pID=<%= participant.getpID() %>" 
                           class="btn btn-danger btn-sm" 
                           onclick="return confirm('Are you sure you want to delete this participant?');">
                            Delete
                        </a>
                        
                       
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





