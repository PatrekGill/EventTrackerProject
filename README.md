# EventTrackerProject
MyGameList

## Overview
MyGameList is to be a simple game-tracker/database for videogames. At the moment, it is entirely a REST API with limited functionality mostly geared towards queries. The database schema was designed in MySQL Workbench.

### REST API
The only current full CRUD operations are available on Game and GameComment. POST methods create, PUT update, GETs retrieve, and DELETE will delete. The reference sheet below includes currently available mappings.

### HTML/JavaScript Front End

### Angular Front End

## REST API Reference
| Return Type        | HTTP Method | URI                                            | Request Body                                    | Purpose                                              |
|--------------------|-------------|------------------------------------------------|-------------------------------------------------|------------------------------------------------------|
| List<Company>      | GET         | /api/companies                                 |                                                 | List of all                                          |
| Company            | GET         | /api/companies/{id}                            |                                                 | Retrieve                                             |
| List<GameCompany>  | GET         | /api/companies/{id}/gameroles                  |                                                 | List of company games with roles                     |
| List<Game>         | GET         | /api/companies/{id}/games                      |                                                 | List of company games without roles                  |
| List<Company>      | GET         | /api/companies/search/{name}                   |                                                 | Search by name                                       |
| List<Company>      | GET         | /api/companies/search/{name}/{numberOfEntries} |                                                 | Search by name, limit return                         |
| GameComment        | GET         | /api/GameComment/{id}                          |                                                 | Retrieve                                             |
| List<GameComment>  | GET         | /api/GameComment/{id}/replies                  |                                                 | Get replies to comment                               |
| GameComment        | GET         | /api/GameComment/{id}/replyTo                  |                                                 | Get comment that was replied to                      |
| GameComment        | POST        | /api/GameComment                               | GameComment (Required fields: text, game, user) | Create comment                                       |
| GameComment        | PUT         | /api/GameComment/{id}                          | GameComment (Updatable fields: text)            | Update comment                                       |
| GameComment        | POST        | /api/GameComment/{id}                          | GameComment (Required fields: text, game, user) | Create reply to comment                              |
| void               | DELETE      | /api/GameComment                               |                                                 | Delete comment                                       |
| List<Game>         | GET         | /api/games                                     |                                                 | List of all                                          |
| Game               | GET         | /api/games/{id}                                |                                                 | Retrieve                                             |
| List<GameCompany>  | GET         | /api/games/{id}/companyroles                   |                                                 | List of companies for game with roles                |
| List<Company>      | GET         | /api/games/{id}/companies                      |                                                 | List of companies for game without roles             |
| List<Platform>     | GET         | /api/games/{id}/platforms                      |                                                 | List of platforms for game                           |
| List<GameRelation> | GET         | /api/games/{id}/relationships                  |                                                 | List of games and their relation to provided game id |
| List<GameStaff>    | GET         | /api/games/{id}/staff/roles                    |                                                 | List of staff on game and their role                 |
| List<GameRelease>  | GET         | /api/games/{id}/releases                       |                                                 | List of game's releases                              |
| List<GameComment>  | GET         | /api/games/{id}/comments                       |                                                 | List of comments on game                             |
| Game               | POST        | /api/games                                     | Game (Required fields: title, description)      | Create game                                          |
| Game               | PUT         | /api/games/{id}                                | Game (Required fields: title, description)      | Update game                                          |
| void               | DELETE      | /api/games/{id}                                |                                                 | Delete game                                          |
| List<Staff>        | GET         | /api/games/{id}/staff                          |                                                 | List of staff on game without their role             |
| GameList           | GET         | /api/gameLists/{id}                            |                                                 | GameList by id                                       |
| List<Game>         | GET         | /api/gameLists/{id}/games                      |                                                 | List of games on GameList                            |
| List<Game>         | GET         | /api/games/search/{keyword}                    |                                                 | Search by game title                                 |
| List<Platform>     | GET         | /api/platforms                                 |                                                 | List of all                                          |
| Platform           | GET         | /api/platforms/{id}                            |                                                 | Retrieve                                             |
| List<Game>         | GET         | /api/platforms/{id}/games                      |                                                 | List of games for platform                           |
| List<Staff>        | GET         | /api/staff                                     |                                                 | List of all                                          |
| Staff              | GET         | /api/staff/{id}                                |                                                 | Retrieve                                             |
| List<Game>         | GET         | /api/staff/{id}/games                          |                                                 | List of games by staff                               |
| List<Status>       | GET         | /api/status                                    |                                                 | List of all                                          |
| Status             | GET         | /api/status/{id}                               |                                                 | Retrieve                                             |

## Technologies Used
Spring MVC, Hibernate, Spring Boot, Spring Data JPA, Spring Tool Suite 4, Postman, Java 8, Gradle, JUnit 5, MAMP, SQL (MySQL), Git terminal, MAC OS, MySQL Workbench

## Things That Can Be Done Better (at the moment)
- Consistency in URI with regards to capitalization
- More organized service objects and controllers

## Lessons Learned (at the moment)
- Start smaller with service objects
I would've helped me greatly to have started on smaller object to fully-implement CRUD operations as a template, rather then spending my time with completing so much of the relationships with the main table `Game`.
