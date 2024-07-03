package com.example.MovieserieV2.service;

import com.example.MovieserieV2.repsitoty.UtilisateurRepository;
import com.example.MovieserieV2.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur saveUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> updateUser(long id, Utilisateur updatedUser) {
        return utilisateurRepository.findById(id).map(existingUser -> {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setNom(updatedUser.getNom());
            existingUser.setPassword(updatedUser.getPassword());
            return utilisateurRepository.save(existingUser);
        });
    }

    public void deleteUserById(long id) {
        utilisateurRepository.deleteById(id);
    }

    public  List<Utilisateur> findAllByPasswordAndEmail(String email, String password){
        return utilisateurRepository.findAllByPasswordAndEmail( email ,  password);
    }
}
