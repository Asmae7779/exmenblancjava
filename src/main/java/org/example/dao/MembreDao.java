package org.example.dao;

import org.example.entity.Membre;

import java.util.List;

public interface MembreDao {
    void ajouterMembre(Membre membre);
    void supprimerMembre(int id);
    Membre obtenirMembre(int id);
    List<Membre> obtenirTousLesMembres();
}
