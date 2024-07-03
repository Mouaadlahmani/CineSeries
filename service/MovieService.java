package com.example.MovieserieV2.service;

import com.example.MovieserieV2.repsitoty.MovieRepository;
import com.example.MovieserieV2.dto.MovieDTO;
import com.example.MovieserieV2.model.Movie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = convertToEntity(movieDTO);
        movie = movieRepository.save(movie);
        return convertToDTO(movie);
    }

    public Optional<MovieDTO> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(this::convertToDTO);
    }

    public boolean deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return false;
    }

    public Optional<MovieDTO> updateMovie(Long id, MovieDTO movieDTO) {
        return movieRepository.findById(id).map(existingMovie -> {
            Movie updatedMovie = convertToEntity(movieDTO);
            updatedMovie.setId_Movie(existingMovie.getId_Movie()); // Ensure the ID is preserved
            updatedMovie = movieRepository.save(updatedMovie);
            return convertToDTO(updatedMovie);
        });
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        BeanUtils.copyProperties(movie, dto);
        return dto;
    }

    private Movie convertToEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);
        return movie;
    }
    public List<Movie> getFilmByGenre(String Genre){
        return movieRepository.findByGenre(Genre);
    }

}
