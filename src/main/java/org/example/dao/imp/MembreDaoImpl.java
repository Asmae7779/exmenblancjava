package org.example.dao.imp;

import org.example.dao.MembreDao;
import org.example.entity.Membre;

import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    private List<Membre> membres = new ArrayList<>();


    public void ajouterMembre(Membre membre) {
        membres.add(membre);
    }


    public void supprimerMembre(int id) {
        membres.removeIf(membre -> membre.getId() == id);
    }


    public Membre obtenirMembre(int id) {
        return membres.stream().filter(membre -> membre.getId() == id).findFirst().orElse(null);
    }


    public List<Membre> obtenirTousLesMembres() {
        return new ArrayList<>(membres);
    }
}
