package org.example.dao.imp;

import org.example.entity.Incident;

import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private List<Incident> incidents = new ArrayList<>();

    @Override
    public void ajouterIncident(Incident incident) {
        incidents.add(incident);
    }

    @Override
    public void supprimerIncident(int id) {
        incidents.removeIf(incident -> incident.getId() == id);
    }

    @Override
    public Incident obtenirIncident(int id) {
        return incidents.stream().filter(incident -> incident.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Incident> obtenirTousLesIncidents() {
        return new ArrayList<>(incidents);
    }
}

