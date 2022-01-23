export class Game {
  id: number;
  title: string | null;
  description: string | null;
  imageURL: string | null;
  updatedDateTime: Date | null;
  createdDateTime: Date | null;

  constructor(
    title: string = "",
    description: string = "",
    imageURL: string = "",
    id: number = 0,
    updatedDateTime: Date | null = null,
    createdDateTime: Date | null = null
  ) {
    this.title = title;
    this.id = id;
    this.description = description;
    this.imageURL = imageURL;
    this.createdDateTime = createdDateTime;
    this.updatedDateTime = updatedDateTime;
  }
}
