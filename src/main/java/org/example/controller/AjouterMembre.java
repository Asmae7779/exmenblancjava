package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AjouterMembre{

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;

    @FXML
    public void handleAjouterMembre() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Champs incomplets");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Membre ajoutre");
            alert.setHeaderText(null);
            alert.setContentText("Le membre ajouté avec succes");
            alert.showAndWait();
        }
    }
}
