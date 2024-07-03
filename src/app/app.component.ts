import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DetailsComponent } from './details/details.component';

interface Film{
  titre: String;
  dateDebut: String;
  genre: String;
  realisateur: String;
  note:Float32Array;
  imgLien: String;
}

interface Movie{
  titre: String;
  note:Float32Array;
  dateDeSortie: String;
  imgLien: String;
  genre: String;
}
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, DetailsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'MovieSeries';
  filmList: Film[] = [];
  movieList: Movie[] = [];

  
  constructor(private httpClient: HttpClient){}
  ngOnInit(): void {
    this.httpClient.get<Film[]>("http://localhost:8080/api/series").subscribe(response =>{
      this.filmList = response;
      console.log(this.filmList);
    }, error =>{
      console.log("error occured while fetching film list");
    });

    this.httpClient.get<Movie[]>("http://localhost:8080/api/movies").subscribe(response =>{
      this.movieList = response;
      console.log(this.movieList);
    }, error =>{
      console.log("error occured while fetching film list");
    });
}
}