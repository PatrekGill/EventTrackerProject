import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
  editedGame: Game | null;
  newGame: Game;
  closeResult: string | undefined;

  constructor(
    private gameSvc: GameService,
    private gameCommentSvc: GamecommentService,
    private modalService: NgbModal
  ) {
    this.selectedGame = null;
    this.editedGame = null;
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

  openVerticallyCentered(content: any, game: Game) {
    this.editedGame = Object.assign({}, game);
    this.modalService.open(content, { centered: true, size: "lg" });
  }

  createGame(game: Game) {
    this.gameSvc.create(game).subscribe(
      {
        next: created => {
          this.newGame = new Game();
          this.loadGamesArray();
        },
        error: fail => {
          console.log("Failed to create game: " + fail.error);

        }
      }
    )
  }

  updateGame(game: Game) {
    this.gameSvc.update(game).subscribe(
      {
        next: updated => {
          this.editedGame = null;
          this.loadGamesArray();
        },
        error: fail => {
          console.log("Failed to update game: " + fail.error);

        }
      }
    )
  }
}
