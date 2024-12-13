package org.example.dao.imp;

import org.example.dao.MembreDao;
import org.example.entity.Membre;

import java.util.ArrayList;
import java.util.List;
import org.example.util.DatabaseConnection;

import java.sql.*;

public class MembreDaoImpl implements MembreDao {

    @Override
    public void ajouterMembre(Membre membre) {
        String sql = "INSERT INTO membres (id, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, membre.getId());
            preparedStatement.setString(2, membre.getNom());
            preparedStatement.setString(3, membre.getPrenom());
            preparedStatement.setString(4, membre.getEmail());
            preparedStatement.setString(5, membre.getPhone());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerMembre(int id) {
        String sql = "DELETE FROM membres WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Membre obtenirMembre(int id) {
        String sql = "SELECT * FROM membres WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Membre(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        null // Remplacer par un appel à un DAO si nécessaire pour récupérer les incidents
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Membre> obtenirTousLesMembres() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM membres";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Membre membre = new Membre(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        null // Remplacer par un DAO pour récupérer les incidents associés
                );
                membres.add(membre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }
}
