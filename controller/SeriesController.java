package com.example.MovieserieV2.controller;

import com.example.MovieserieV2.dto.SeriesDTO;
import com.example.MovieserieV2.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    @Autowired
    private SeriesService serieService;

    @GetMapping
    public ResponseEntity<List<SeriesDTO>> getAllSeries() {
        return ResponseEntity.ok(serieService.getAllSerie());
    }

    @PostMapping
    public ResponseEntity<SeriesDTO> addSeries(@RequestBody SeriesDTO seriesDTO) {
        return ResponseEntity.ok(serieService.addSeries(seriesDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Long id) {
        Optional<SeriesDTO> series = serieService.getSeriesById(id);
        return series.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        serieService.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeries(@PathVariable Long id, @RequestBody SeriesDTO seriesDTO) {
        Optional<SeriesDTO> updatedSeries = serieService.updateSeries(id, seriesDTO);
        if (updatedSeries.isPresent()) {
            return ResponseEntity.ok(updatedSeries.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Series not found with id: " + id);
        }
    }
    @DeleteMapping("/last")
    public ResponseEntity<Void> deleteLastInsertedSeries() {
        serieService.deleteLastInsertedSeries();
        return ResponseEntity.noContent().build();
    }
}
