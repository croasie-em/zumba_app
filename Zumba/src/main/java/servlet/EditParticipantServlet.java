package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Participants;

import java.io.IOException;

import database.ParticipantsDatabase;

/**
 * Servlet implementation class EditParticipantServlet
 */
@WebServlet("/editParticipant")
public class EditParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int pID = Integer.parseInt(request.getParameter("pID"));
            System.out.println("Received pID: " + pID); // Debugging log

            ParticipantsDatabase db = new ParticipantsDatabase();
            Participants participant = db.getParticipants(pID);

            if (participant != null) {
                request.setAttribute("participant", participant);
                request.getRequestDispatcher("editParticipant.jsp").forward(request, response);
            } else {
                System.out.println("Participant not found for pID: " + pID); // Debugging log
                request.setAttribute("error", "Participant not found.");
                request.getRequestDispatcher("viewparticipants.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid pID: " + request.getParameter("pID")); // Debugging log
            request.setAttribute("error", "Invalid participant ID.");
            request.getRequestDispatcher("viewparticipants.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process the update form submission
        int pID = Integer.parseInt(request.getParameter("pID"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        int batchID = Integer.parseInt(request.getParameter("batchID"));

        Participants participant = new Participants(pID, name, email, phone, gender, batchID);
        ParticipantsDatabase db = new ParticipantsDatabase();
        boolean updated = db.updateParticipants(participant);

        if (updated) {
            response.sendRedirect("viewparticipants.jsp");
        } else {
            request.setAttribute("error", "Failed to update participant.");
            request.getRequestDispatcher("editParticipant.jsp").forward(request, response);
        }
    }
}