package com.example.MovieserieV2.dto;

import lombok.Data;

@Data
public class FavoriteDTO {
        private Long id_Favoris;
        private Long movieId;
        private Long seriesId;
}
