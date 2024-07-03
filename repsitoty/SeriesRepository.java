package com.example.MovieserieV2.repsitoty;

import com.example.MovieserieV2.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    @Query(value = "SELECT s FROM Series s ORDER BY s.id_Series DESC")
    Series findTopByOrderById_SeriesDesc();
}
