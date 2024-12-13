package org.example.entity;

import java.util.List;
import java.util.Objects;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;

    // Constructeur
    public Membre(int id, String nom, String prenom, String email, String phone, List<Incident> incidents) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = incidents;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<Incident> getIncidents() { return incidents; }
    public void setIncidents(List<Incident> incidents) { this.incidents = incidents; }

    // Redéfinition de equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return id == membre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

