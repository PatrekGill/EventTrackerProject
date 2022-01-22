import { Component, OnInit } from '@angular/core';
import { GameService } from 'src/app/services/game.service';
import { GamecommentService } from 'src/app/services/gamecomment.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private gameSvc: GameService,
    private gameCommentSvc: GamecommentService
  ) { }

  ngOnInit(): void {
  }

}
