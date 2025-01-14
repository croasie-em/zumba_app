package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Batches;

import java.io.IOException;
import java.time.LocalDate;

import database.BatchesDatabase;

/**
 * Servlet implementation class EditBatchServlet
 */
@WebServlet("/editBatch")
public class EditBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the parameter 'BatchID' from the URL (case-sensitive)
            int batchID = Integer.parseInt(request.getParameter("BatchID"));
            System.out.println("Received BatchID: " + batchID); // Debugging log

            BatchesDatabase db = new BatchesDatabase();
            Batches batch = db.getBatchById(batchID);

            if (batch != null) {
                request.setAttribute("batch", batch);
                request.getRequestDispatcher("editBatch.jsp").forward(request, response);
            } else {
                System.out.println("Batch not found for BatchID: " + batchID); // Debugging log
                request.setAttribute("error", "Batch not found.");
                request.getRequestDispatcher("viewbatches.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid BatchID: " + request.getParameter("BatchID")); // Debugging log
            request.setAttribute("error", "Invalid Batch ID.");
            request.getRequestDispatcher("viewbatches.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process the update form submission
        int batchID = Integer.parseInt(request.getParameter("BatchID"));
        String name = request.getParameter("name");
        String day = request.getParameter("day");
        String timeOfDay = request.getParameter("timeOfDay");
        String maxSize = request.getParameter("maxSize");
        String startDateString = request.getParameter("startDate");
        String endDateString = request.getParameter("endDate");
        
        // Convert startDate and endDate from String to LocalDate
        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = LocalDate.parse(endDateString);

        // Construct the Batches object using the received parameters
        Batches batch = new Batches(batchID, name, day, timeOfDay, Integer.parseInt(maxSize), startDate, endDate);
        
        BatchesDatabase db = new BatchesDatabase();
        boolean updated = db.updateBatch(batch);

        if (updated) {
            response.sendRedirect("viewbatches.jsp");
        } else {
            request.setAttribute("error", "Failed to update batch.");
            request.getRequestDispatcher("editBatch.jsp").forward(request, response);
        }
    }
}

