import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule} from '@angular/common';

interface Film{
  titre: String;
  dateSortie: String;
  genre: String;
  realisateur: String;
  note:Float32Array
}
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
   title= 'Angular';
  filmList: Film[] = [];

  
  constructor(private httpClient: HttpClient){}
  ngOnInit(): void {
    this.httpClient.get<Film[]>("http://localhost:8080/film/read").subscribe(response =>{
      this.filmList = response;
      console.log(this.filmList);
    }, error =>{
      console.log("error occured while fetching film list");
    });

  }
}
