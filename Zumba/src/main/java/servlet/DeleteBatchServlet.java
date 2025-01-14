package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import database.BatchesDatabase;

@WebServlet("/deleteBatch")
public class DeleteBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteBatchServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get BatchID from the query string
            int batchID = Integer.parseInt(request.getParameter("BatchID"));
            BatchesDatabase db = new BatchesDatabase();

            // Call delete method from BatchesDatabase
            boolean success = db.deleteBatch(batchID);

            if (success) {
                // success delete message
            	request.setAttribute("message", "Batch deleted successfully.");
            } else {
                // Show error message if deletefailed
                request.setAttribute("error", "Failed to delete Batch.");
               
            }
            request.getRequestDispatcher("viewbatches.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Batch ID.");
            request.getRequestDispatcher("viewbatches.jsp").forward(request, response);
        }
    }
}
