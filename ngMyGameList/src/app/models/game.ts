export class Game {
  id: number;
  title: string | null;
  description: string | null;
  imageUrl: string | null;
  updatedDateTime: Date | null;
  createdDateTime: Date | null;

  constructor(
    title: string = "",
    description: string = "",
    imageUrl: string = "",
    id: number = 0,
    updatedDateTime: Date | null = null,
    createdDateTime: Date | null = null
  ) {
    this.title = title;
    this.id = id;
    this.description = description;
    this.imageUrl = imageUrl;
    this.createdDateTime = createdDateTime;
    this.updatedDateTime = updatedDateTime;
  }
}