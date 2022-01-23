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
  newGame: Game;

  constructor(
    private gameSvc: GameService,
    private gameCommentSvc: GamecommentService
  ) {
    this.selectedGame = null;
    this.newGame = new Game();
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

  createGame(game: Game) {
    this.gameSvc.create(game).subscribe(
      {
        next: created => {
          this.newGame = new Game();
          this.loadGamesArray();
        },
        error: fail => {
          console.log("Failed to creeate game: " + fail.error);

        }
      }
    )
  }
}
