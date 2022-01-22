import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private baseUrl = 'http://localhost:8083/';
  private url = 'api/games';

  constructor(
    private http: HttpClient
  ) { }
}
