export class User {
  id: number;
  username: string | null;
  password: string | null;
  updatedDateTime: Date | null;
  createdDateTime: Date | null;

  constructor(
    id: number = 0,
    username: string | null = null,
    password: string | null = null,
    updatedDateTime: Date | null = null,
    createdDateTime: Date | null = null

  ) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.createdDateTime = createdDateTime;
    this.updatedDateTime = updatedDateTime;
  }
}

