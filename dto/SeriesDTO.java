package com.example.MovieserieV2.dto;

import lombok.Data;

@Data
public class SeriesDTO {
    private Long id_Series;
    private String titre;
    private String description;
    private String dateDebut;
    private String dateFin;
    private Integer nombreSaisons;
    private String genre;
    private String createur;
    private String acteurs;
    private Double note;
    private String imgLien; // Added field for image link
}
