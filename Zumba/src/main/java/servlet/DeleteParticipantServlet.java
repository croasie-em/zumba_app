package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import database.ParticipantsDatabase;

@WebServlet("/deleteParticipant")
public class DeleteParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteParticipantServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get pID from the query string
            int pID = Integer.parseInt(request.getParameter("pID"));
            ParticipantsDatabase db = new ParticipantsDatabase();

            // Call delete method from ParticipantsDatabase
            boolean success = db.deleteParticipant(pID);

            if (success) {
                // success delete message
            	request.setAttribute("message", "Participant deleted successfully.");
            } else {
                // Show error message if deletefailed
                request.setAttribute("error", "Failed to delete participant.");
               
            }
            request.getRequestDispatcher("viewparticipants.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid participant ID.");
            request.getRequestDispatcher("viewparticipants.jsp").forward(request, response);
        }
    }
}

