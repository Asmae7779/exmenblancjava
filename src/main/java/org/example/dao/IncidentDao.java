package org.example.dao;
import org.example.entity.Incident;

import java.util.List;

public interface IncidentDao {
    void ajouterIncident(Incident incident);
    void supprimerIncident(int id);
    Incident obtenirIncident(int id);
    List<Incident> obtenirTousLesIncidents();
}

