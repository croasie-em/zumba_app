<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batches Home</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h3>Create a New Batch</h3>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="registerBatch" method="post" class="p-4 border rounded shadow-sm bg-light">


                    <div class="mb-3">
                        <label for="txtName" class="form-label">Enter Name:</label>
                        <input type="name" id="txtName" name="txtName" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="txtDay" class="form-label">Enter Day:</label>
                        <input type="text" id="txtDay" name="txtDay" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="txtTimeOfDay" class="form-label">Enter Time of Day:</label>
                        <select id="txtTimeOfDay" name="txtTimeOfDay" class="form-select" required>
                            <option value="">Select Time</option>
                            <option value="Morning">Morning</option>
                            <option value="Afternoon">Afternoon</option>
                            <option value="Evening">Evening</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="txtMaxSize" class="form-label">Enter Max Size of Batch:</label>
                        <input type="text" id="txtMaxSize" name="txtMaxSize" class="form-control" required>
                    </div>
                    
                      <div class="mb-3">
                        <label for="dateStartDate" class="form-label">Enter Start Date:</label>
                        <input type="date" id="dateStartDate" name="dateStartDate" class="form-control" required>
                    </div>  
                                    
                      <div class="mb-3">
                        <label for="dateEndDate" class="form-label">Enter End Date:</label>
                        <input type="date" id="dateEndDate" name="dateEndDate" class="form-control" required>
                    </div> 
                    
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="text-center mt-4">
            <h2>View/Edit Current Batches</h2>
            <a href="viewbatches.jsp" class="btn btn-secondary me-2">View Batches</a>
            <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
        </div>
    </div>

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>