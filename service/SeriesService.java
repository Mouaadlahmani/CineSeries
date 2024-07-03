package com.example.MovieserieV2.service;

import com.example.MovieserieV2.repsitoty.SeriesRepository;
import com.example.MovieserieV2.dto.SeriesDTO;
import com.example.MovieserieV2.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<SeriesDTO> getAllSerie() {
        return seriesRepository.findAll().stream().map(series -> {
            SeriesDTO dto = new SeriesDTO();
            dto.setId_Series(series.getId_Series());
            dto.setTitre(series.getTitre());
            dto.setDescription(series.getDescription());
            dto.setDateDebut(series.getDateDebut());
            dto.setDateFin(series.getDateFin());
            dto.setNombreSaisons(series.getNombreSaisons());
            dto.setGenre(series.getGenre());
            dto.setCreateur(series.getCreateur());
            dto.setActeurs(series.getActeurs());
            dto.setNote(series.getNote());
            dto.setImgLien(series.getImgLien()); // Added field for image link
            return dto;
        }).collect(Collectors.toList());
    }

    public SeriesDTO addSeries(SeriesDTO seriesDTO) {
        Series series = new Series();
        series.setTitre(seriesDTO.getTitre());
        series.setDescription(seriesDTO.getDescription());
        series.setDateDebut(seriesDTO.getDateDebut());
        series.setDateFin(seriesDTO.getDateFin());
        series.setNombreSaisons(seriesDTO.getNombreSaisons());
        series.setGenre(seriesDTO.getGenre());
        series.setCreateur(seriesDTO.getCreateur());
        series.setActeurs(seriesDTO.getActeurs());
        series.setNote(seriesDTO.getNote());
        series.setImgLien(seriesDTO.getImgLien()); // Added field for image link
        series = seriesRepository.save(series);
        return seriesDTO;
    }

    public Optional<SeriesDTO> getSeriesById(Long id) {
        Optional<Series> series = seriesRepository.findById(id);
        return series.map(s -> {
            SeriesDTO dto = new SeriesDTO();
            dto.setId_Series(s.getId_Series());
            dto.setTitre(s.getTitre());
            dto.setDescription(s.getDescription());
            dto.setDateDebut(s.getDateDebut());
            dto.setDateFin(s.getDateFin());
            dto.setNombreSaisons(s.getNombreSaisons());
            dto.setGenre(s.getGenre());
            dto.setCreateur(s.getCreateur());
            dto.setActeurs(s.getActeurs());
            dto.setNote(s.getNote());
            dto.setImgLien(s.getImgLien()); // Added field for image link
            return dto;
        });
    }

    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }

    public Optional<SeriesDTO> updateSeries(Long id, SeriesDTO seriesDTO) {
        Optional<Series> seriesOptional = seriesRepository.findById(id);
        if (seriesOptional.isPresent()) {
            Series series = seriesOptional.get();
            series.setTitre(seriesDTO.getTitre());
            series.setDescription(seriesDTO.getDescription());
            series.setDateDebut(seriesDTO.getDateDebut());
            series.setDateFin(seriesDTO.getDateFin());
            series.setNombreSaisons(seriesDTO.getNombreSaisons());
            series.setGenre(seriesDTO.getGenre());
            series.setCreateur(seriesDTO.getCreateur());
            series.setActeurs(seriesDTO.getActeurs());
            series.setNote(seriesDTO.getNote());
            series.setImgLien(seriesDTO.getImgLien()); // Added field for image link
            seriesRepository.save(series);
            return Optional.of(seriesDTO);
        }
        return Optional.empty();
    }
    public void deleteLastInsertedSeries() {
        Series lastSeries = seriesRepository.findTopByOrderById_SeriesDesc();
        if (lastSeries != null) {
            seriesRepository.deleteById(lastSeries.getId_Series());
        }
    }
}
