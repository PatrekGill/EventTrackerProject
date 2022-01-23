import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { GameService } from './services/game.service';
import { GamecommentService } from './services/gamecomment.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TagService } from './services/tag.service';
import { GamesComponent } from './components/games/games.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    GamesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [
    GameService,
    GamecommentService,
    TagService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
