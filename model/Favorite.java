package com.example.MovieserieV2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Favoris")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Favoris;

    @ManyToOne
    @JoinColumn(name = "id_Movie", referencedColumnName = "id_Movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_Series", referencedColumnName = "id_Series")
    private Series series;

}
