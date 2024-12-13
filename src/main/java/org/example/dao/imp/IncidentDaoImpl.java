package org.example.dao.imp;

import org.example.dao.IncidentDao;
import org.example.entity.Incident;

import java.util.ArrayList;
import java.util.List;
import org.example.util.DatabaseConnection;
import java.sql.*;

public class IncidentDaoImpl implements IncidentDao {

    @Override
    public void ajouterIncident(Incident incident) {
        String sql = "INSERT INTO incidents (id, reference, time_status, membre_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, incident.getId());
            preparedStatement.setString(2, incident.getReference());
            preparedStatement.setString(3, incident.getTimeStatus());
            preparedStatement.setInt(4, incident.getMembre().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerIncident(int id) {
        String sql = "DELETE FROM incidents WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Incident obtenirIncident(int id) {
        String sql = "SELECT * FROM incidents WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Incident(
                        resultSet.getInt("id"),
                        resultSet.getString("reference"),
                        resultSet.getString("time_status"),
                        null // Remplacer par un DAO pour récupérer le membre si nécessaire
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Incident> obtenirTousLesIncidents() {
        List<Incident> incidents = new ArrayList<>();
        String sql = "SELECT * FROM incidents";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Incident incident = new Incident(
                        resultSet.getInt("id"),
                        resultSet.getString("reference"),
                        resultSet.getString("time_status"),
                        null // Remplacer par un DAO pour récupérer le membre si nécessaire
                );
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
}
