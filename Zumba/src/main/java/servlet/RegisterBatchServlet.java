package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Batches;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import database.BatchesDatabase;
import database.MyConnection;

/**
 * Servlet implementation class RegisterBatchServlet
 */
@WebServlet("/registerBatch")
public class RegisterBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    // Get parameters from the request
//        String batchIDStr = request.getParameter("txtBatchID"); is auto increment so don't need batch_ID in this one
        String name = request.getParameter("txtName");
        String day = request.getParameter("txtDay");
        String timeOfDay = request.getParameter("txtTimeOfDay");
        String maxSizeStr = request.getParameter("txtMaxSize");
        String startDateStr = request.getParameter("dateStartDate");
        String endDateStr = request.getParameter("dateEndDate");

        // Convert  maxSize to integer, and start/end dates to LocalDate
        
        int maxSize = 0;
        LocalDate startDate = null;
        LocalDate endDate = null;

        try {
            
            maxSize = Integer.parseInt(maxSizeStr);
            startDate = LocalDate.parse(startDateStr);
            endDate = LocalDate.parse(endDateStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid input format for Max Size, or Dates.");
            request.getRequestDispatcher("batches.jsp").forward(request, response);
            return;
        }

        // Create a Batch object and set its properties
        Batches batch = new Batches();
        
        batch.setName(name);
        batch.setDay(day);
        batch.setTimeOfDay(timeOfDay);
        batch.setMaxSize(maxSize);
        batch.setStartDate(startDate);
        batch.setEndDate(endDate);

        // Insert the batch into the database
        BatchesDatabase batchesDatabase = new BatchesDatabase();
        try {
            boolean isInserted = batchesDatabase.insert(batch);
            if (isInserted) {
                response.sendRedirect("viewbatches.jsp"); // Redirect to view batches page if successful
            } else {
                request.setAttribute("error", "Batch registration failed. Please try again.");
                request.getRequestDispatcher("batches.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("batches.jsp").forward(request, response);
        }
	}}
