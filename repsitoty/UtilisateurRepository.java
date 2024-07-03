package com.example.MovieserieV2.repsitoty;


import com.example.MovieserieV2.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

     List<Utilisateur> findAllByPasswordAndEmail(String email, String password);
}
