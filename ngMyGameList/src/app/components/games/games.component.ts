import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';
import { GameService } from 'src/app/services/game.service';
import { GamecommentService } from 'src/app/services/gamecomment.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {
  games: Game[] = [];
  selectedGame: Game | null;

  constructor(
    private gameSvc: GameService,
    private gameCommentSvc: GamecommentService
  ) {
    this.selectedGame = null;
  }

  ngOnInit(): void {
    this.loadGamesArray();
  }

  loadGamesArray() {
    this.gameSvc.getAll().subscribe(
      {
        next: gamesFromDatabase => this.games = gamesFromDatabase,
        error: err => console.error("loadGamesArray() -> Observer got an error: " + err)
      }
    );
  }
}
