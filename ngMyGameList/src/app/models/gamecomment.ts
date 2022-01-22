import { Game } from "./game";
import { User } from "./user";

export class Gamecomment {
  id: number;
  user: User;
  game: Game;
  text: string;
  visible: boolean;
  inReplyTo: Gamecomment | null;
  updatedDateTime: Date | null;
  createdDateTime: Date | null;

  constructor(
    user: User,
    game: Game,
    id:number = 0,
    text:string = "",
    visible: boolean = true,
    inReplyTo: Gamecomment | null = null,
    updatedDateTime: Date | null = null,
    createdDateTime: Date | null = null

  ) {
    this.id = id;
    this.game = game;
    this.user = user;
    this.text = text;
    this.visible = visible;
    this.inReplyTo = inReplyTo;
    this.createdDateTime = createdDateTime;
    this.updatedDateTime = updatedDateTime;
  }
}


