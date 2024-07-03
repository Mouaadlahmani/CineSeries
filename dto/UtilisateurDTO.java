package com.example.MovieserieV2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtilisateurDTO {
    private int id_Utilisateur;
    private String email;
    private String nom;
    private String password;

}
