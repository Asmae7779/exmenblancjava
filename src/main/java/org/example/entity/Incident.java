package org.example.entity;

public class Incident {
    private int id;
    private String reference;
    private String timeStatus;
    private Membre membre;

    // Constructeur
    public Incident(int id, String reference, String timeStatus, Membre membre) {
        this.id = id;
        this.reference = reference;
        this.timeStatus = timeStatus;
        this.membre = membre;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public String getTimeStatus() { return timeStatus; }
    public void setTimeStatus(String timeStatus) { this.timeStatus = timeStatus; }

    public Membre getMembre() { return membre; }
    public void setMembre(Membre membre) { this.membre = membre; }
}
