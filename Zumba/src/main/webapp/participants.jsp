<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Participants Home</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h3>Register a Participant</h3>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="registerParticipant" method="post" class="p-4 border rounded shadow-sm bg-light">
                    <div class="mb-3">
                        <label for="txtName" class="form-label">Enter Name:</label>
                        <input type="text" id="txtName" name="txtName" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="txtEmail" class="form-label">Enter Email:</label>
                        <input type="email" id="txtEmail" name="txtEmail" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="txtPhone" class="form-label">Enter Phone:</label>
                        <input type="text" id="txtPhone" name="txtPhone" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="txtGender" class="form-label">Enter Gender:</label>
                        <select id="txtGender" name="txtGender" class="form-select" required>
                            <option value="">Select Gender</option>
                            <option value="M">Male</option>
                            <option value="F">Female</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="txtBatchID" class="form-label">Enter Batch ID:</label>
                        <input type="text" id="txtBatchID" name="txtBatchID" class="form-control" required>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="text-center mt-4">
            <h2>View/Edit Current Participants</h2>
            <a href="viewparticipants.jsp" class="btn btn-secondary me-2">View Participants</a>
            <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
        </div>
    </div>

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
