package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import database.MyConnection;
import model.Participants;

@WebServlet("/registerParticipant")
public class RegisterParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String name = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String gender = request.getParameter("txtGender");
        String batchIDStr = request.getParameter("txtBatchID");

        // Convert batchID to an integer
        int batchID;
        try {
            batchID = Integer.parseInt(batchIDStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Batch ID format.");
            request.getRequestDispatcher("participants.jsp").forward(request, response);
            return;
        }

        // Create a Participant object
        Participants participant = new Participants();
        participant.setName(name);
        participant.setEmail(email);
        participant.setPhone(phone);
        participant.setGender(gender);
        participant.setBatchID(batchID);

        // Insert the participant into the database
        try (Connection con = MyConnection.getConnection()) {
            String sql = "INSERT INTO participants (name, email, phone, gender, BatchID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getEmail());
            stmt.setString(3, participant.getPhone());
            stmt.setString(4, participant.getGender());
            stmt.setInt(5, participant.getBatchID());
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                response.sendRedirect("viewparticipants.jsp"); // Redirect to view participants page
            } else {
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("participants.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("participants.jsp").forward(request, response);
        }
    }
}

