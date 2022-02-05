import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Game } from '../models/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  // private baseUrl = 'http://localhost:8083/';
  private url = environment.baseUrl + 'api/games';

  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<Game[]> {
    return this.http.get<Game[]>(this.url)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(() => 'getAll() Games error');
        })
      );
  }

  getSingle(id:string | number): Observable<Game> {
    return this.http.get<Game>(this.url + "/" + id)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(() => 'getSingle() Game error');
        })
      );
  }

  create(game:Game) {
    return this.http.post<Game>(this.url, game)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(() => 'create() Game error');
        })
      );
  }

  update(edited:Game) {
    return this.http.put<Game>(this.url + `/${edited.id}`, edited)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(() => 'update() Game error');
        })
      );
  }

  delete(id: number | string) {
    return this.http.delete<Game>(this.url + "/" + id)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(() => 'delete() Game error');
        })
      );
  }
}
