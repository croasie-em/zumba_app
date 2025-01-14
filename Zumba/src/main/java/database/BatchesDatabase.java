package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Batches;

public class BatchesDatabase {
    // Insert a new batch
    public boolean insert(Batches b) throws SQLException {
        System.out.println("Inserting batch: " + b);
        Connection con = MyConnection.getConnection();
        String sql = "INSERT INTO batches (batchID, name, day, timeOfDay, maxSize, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, b.getBatchID());
            preparedStatement.setString(2, b.getName());
            preparedStatement.setString(3, b.getDay());
            preparedStatement.setString(4, b.getTimeOfDay());
            preparedStatement.setInt(5, b.getMaxSize());
            preparedStatement.setDate(6, Date.valueOf(b.getStartDate())); // LocalDate to SQL Date
            preparedStatement.setDate(7, Date.valueOf(b.getEndDate()));   // LocalDate to SQL Date

            int rows = preparedStatement.executeUpdate();
            System.out.println("Batch inserted successfully.");
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting batch: " + e.getMessage());
            throw e;

        }
    }

    // Retrieve all batches
    public ArrayList<Batches> getBatches() {
        Connection con = MyConnection.getConnection();
        ArrayList<Batches> batchesList = new ArrayList<>();
        String sql = "SELECT * FROM batches";

        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Batches batch = new Batches();
                batch.setBatchID(rs.getInt("batchID"));
                batch.setName(rs.getString("name"));
                batch.setDay(rs.getString("day"));
                batch.setTimeOfDay(rs.getString("timeOfDay"));
                batch.setMaxSize(rs.getInt("maxSize"));
                batch.setStartDate(rs.getDate("startDate").toLocalDate()); // SQL Date to LocalDate
                batch.setEndDate(rs.getDate("endDate").toLocalDate());     // SQL Date to LocalDate
                batchesList.add(batch);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving batches: " + e.getMessage());
            e.printStackTrace();
        }
        return batchesList;
    }

    // Delete a batch by ID
    public boolean deleteBatch(int batchID) {
        Connection con = MyConnection.getConnection();
        String sql = "DELETE FROM batches WHERE batchID = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, batchID);
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting batch: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Update a batch
    public boolean updateBatch(Batches batch) {
        Connection con = MyConnection.getConnection();
        String sql = "UPDATE batches SET name = ?, day = ?, timeOfDay = ?, maxSize = ?, startDate = ?, endDate = ? WHERE batchID = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, batch.getName());
            preparedStatement.setString(2, batch.getDay());
            preparedStatement.setString(3, batch.getTimeOfDay());
            preparedStatement.setInt(4, batch.getMaxSize());
            preparedStatement.setDate(5, Date.valueOf(batch.getStartDate())); // LocalDate to SQL Date
            preparedStatement.setDate(6, Date.valueOf(batch.getEndDate()));   // LocalDate to SQL Date
            preparedStatement.setInt(7, batch.getBatchID());

            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Error updating batch: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public Batches getBatchById(int batchID) {
        Connection con = MyConnection.getConnection();
        String sql = "SELECT * FROM batches WHERE batchID = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, batchID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Batches batch = new Batches();
                batch.setBatchID(rs.getInt("batchID"));
                batch.setName(rs.getString("name"));
                batch.setDay(rs.getString("day"));
                batch.setTimeOfDay(rs.getString("timeOfDay"));
                batch.setMaxSize(rs.getInt("maxSize"));
                batch.setStartDate(rs.getDate("startDate").toLocalDate());
                batch.setEndDate(rs.getDate("endDate").toLocalDate());
                return batch;
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving batch by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
}

