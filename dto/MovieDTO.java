package com.example.MovieserieV2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
    private Long id_Movie;
    private String titre;
    private String description;
    private String dateDeSortie;  // Ensure the type matches your database (String, Date, LocalDate, etc.)
    private String genre;
    private String realisateur;
    private String acteurs;
    private Double note;
    private String imgLien;

}
