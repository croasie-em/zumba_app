package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.MyConnection;
import model.Participants;

//not included the identifiers as auto increment in database
public class ParticipantsDatabase {
	public boolean insert(Participants p) {
	System.out.println("insert "+p);
	Connection con = MyConnection.getConnection();
	String sql = "insert into participant( name, email, phone, gender, batchID) values(?,?,?,?,?)";
	try {
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, p.getName());
		preparedStatement.setString(2, p.getEmail());
		preparedStatement.setString(3, p.getPhone());
		preparedStatement.setString(4, p.getGender());
		preparedStatement.setInt(5, p.getBatchID());
		preparedStatement.executeUpdate();
		
		System.out.println("executed");
		preparedStatement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("exception");
		e.printStackTrace();
		return false;
	}
	return true;
}
	


	public ArrayList<Participants> getParticipants()
	{
		Connection con = MyConnection.getConnection();
		ArrayList<Participants> participantsList = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from participants");			
			while(rs.next())
			{
				Participants participant = new Participants();
				participant.setpID(rs.getInt(1));
				participant.setName(rs.getString(2));
				participant.setEmail(rs.getString(3));
				participant.setPhone(rs.getString(4));
				participant.setGender(rs.getString(5));	
				participant.setBatchID(rs.getInt(6));				
				participantsList.add(participant);
				
				}
				
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return participantsList;
		
	}
	
	public boolean deleteParticipant(int pID) {
	    Connection con = MyConnection.getConnection();
	    try {
	        // Use prepared statement for security and accuracy
	        String sql = "DELETE FROM participants WHERE pID = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setInt(1, pID);
	        int rowsAffected = statement.executeUpdate();
	        statement.close();

	        return rowsAffected > 0;  // Return true if one or more rows were deleted
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	  // Get a participant by name
//    public Participants getParticipants(String name) {
//        Participants participant = null;
//        String sql = "SELECT * FROM participants WHERE name = ?";
//
//        try (Connection con = MyConnection.getConnection();
//             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, name);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                participant = new Participants();
//                participant.setpID(rs.getInt(1));
//                participant.setName(rs.getString(2));
//                participant.setEmail(rs.getString(3));
//                participant.setPhone(rs.getString(4));
//                participant.setGender(rs.getString(5));
//                participant.setBatchID(rs.getInt(6));
//            }
//
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return participant;
//    }
    
 // Get a participant by ID
    public Participants getParticipants(int pID) {
        Participants participant = null;
        String sql = "SELECT * FROM participants WHERE pID = ?";

        try (Connection con = MyConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, pID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                participant = new Participants();
                participant.setpID(rs.getInt("pID"));
                participant.setName(rs.getString("name"));
                participant.setEmail(rs.getString("email"));
                participant.setPhone(rs.getString("phone"));
                participant.setGender(rs.getString("gender"));
                participant.setBatchID(rs.getInt("batchID"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participant;
    }
	
    // Update a participant
    public boolean updateParticipants(Participants participant) {
        Connection con = MyConnection.getConnection();
        String sql = "UPDATE participants SET name=?, email=?, phone=?, gender=?, batchID=? WHERE pID=?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, participant.getName());
            statement.setString(2, participant.getEmail());
            statement.setString(3, participant.getPhone());
            statement.setString(4, participant.getGender());
            statement.setInt(5, participant.getBatchID());
            statement.setInt(6, participant.getpID()); // WHERE clause

            int rows = statement.executeUpdate();
            statement.close();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
 // Fetch participants by batch ID
    public ArrayList<Participants> getParticipantsByBatch(int batchID) {
        ArrayList<Participants> participantsList = new ArrayList<>();
        String sql = "SELECT * FROM participants WHERE batchID = ?";

        try (Connection con = MyConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, batchID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Participants participant = new Participants();
                participant.setpID(rs.getInt("pID"));
                participant.setName(rs.getString("name"));
                participant.setEmail(rs.getString("email"));
                participant.setPhone(rs.getString("phone"));
                participant.setGender(rs.getString("gender"));
                participant.setBatchID(rs.getInt("batchID"));
                participantsList.add(participant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participantsList;
    }
}

	
	
		
			
		
	
	








		
		

			

	

		
		

			

