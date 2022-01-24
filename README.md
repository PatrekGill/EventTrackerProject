# EventTrackerProject
MyGameList

## Overview
MyGameList is to be a simple game-tracker/database for videogames. At the moment, it is entirely a REST API with limited functionality mostly geared towards queries. The database schema was designed in MySQL Workbench. The entity objects are completed and have corresponding unit tests.
<br />
<br />
The backend is currently not fully implemented, mostly as it relates to data modification (PUT, POST, DELETE). This is largely centered on the decision as to whether or not have certain properties have a disable flag or a chomprehensive deletion. Both come with challenges on such interconnected entities such as the `Game` and `UserGame`.

### REST API
The only current full CRUD operations are available on `Game` and `GameComment`. POST methods create, PUT update, GETs retrieve, and DELETE will delete. The reference sheet below includes currently available mappings, with more to come. Theses were tested using manual Postman calls locally.

### Angular Front End
There is a basic implementation of an Angular front-end that is hooked to the backend. Currently, you can create, update, and delete games from the list.  


## REST API Reference
| Return Type        | HTTP Method | URI                                            | Request Body                                    | Purpose                                              |
|--------------------|-------------|------------------------------------------------|-------------------------------------------------|------------------------------------------------------|
| List\<Company\>      | GET         | /api/companies                                 |                                                 | List of all                                          |
| Company            | GET         | /api/companies/{id}                            |                                                 | Retrieve                                             |
| List\<GameCompany\>  | GET         | /api/companies/{id}/games/roles                  |                                                 | List of company games with roles                     |
| List\<Game\>         | GET         | /api/companies/{id}/games                      |                                                 | List of company games without roles                  |
| List\<Company\>      | GET         | /api/companies/search/{name}                   |                                                 | Search by name                                       |
| List\<Company\>      | GET         | /api/companies/search/{name}/{numberOfEntries} |                                                 | Search by name, limit return                         |
| GameComment        | GET         | /api/GameComment/{id}                          |                                                 | Retrieve                                             |
| List\<GameComment\>  | GET         | /api/GameComment/{id}/replies                  |                                                 | Get replies to comment                               |
| GameComment        | GET         | /api/GameComment/{id}/replyTo                  |                                                 | Get comment that was replied to                      |
| GameComment        | POST        | /api/GameComment                               | GameComment (Required fields: text, game, user) | Create comment                                       |
| GameComment        | PUT         | /api/GameComment/{id}                          | GameComment (Updatable fields: text)            | Update comment                                       |
| GameComment        | POST        | /api/GameComment/{id}                          | GameComment (Required fields: text, game, user) | Create reply to comment                              |
| void               | DELETE      | /api/GameComment                               |                                                 | Delete comment                                       |
| List\<Game\>         | GET         | /api/games                                     |                                                 | List of all                                          |
| Game               | GET         | /api/games/{id}                                |                                                 | Retrieve                                             |
| List\<GameCompany\>  | GET         | /api/games/{id}/companies/roles                   |                                                 | List of companies for game with roles                |
| List\<Company\>      | GET         | /api/games/{id}/companies                      |                                                 | List of companies for game without roles             |
| List\<Platform\>     | GET         | /api/games/{id}/platforms                      |                                                 | List of platforms for game                           |
| List\<GameRelation\> | GET         | /api/games/{id}/relationships                  |                                                 | List of games and their relation to provided game id |
| List\<GameStaff\>    | GET         | /api/games/{id}/staff/roles                    |                                                 | List of staff on game and their role                 |
| List\<GameRelease\>  | GET         | /api/games/{id}/releases                       |                                                 | List of game's releases                              |
| List\<GameComment\>  | GET         | /api/games/{id}/comments                       |                                                 | List of comments on game                             |
| Game               | POST        | /api/games                                     | Game (Required fields: title, description)      | Create game                                          |
| Game               | PUT         | /api/games/{id}                                | Game (Required fields: title, description)      | Update game                                          |
| void               | DELETE      | /api/games/{id}                                |                                                 | Delete game                                          |
| List\<Staff\>        | GET         | /api/games/{id}/staff                          |                                                 | List of staff on game without their role             |
| GameList           | GET         | /api/gameLists/{id}                            |                                                 | GameList by id                                       |
| List\<Game\>         | GET         | /api/gameLists/{id}/games                      |                                                 | List of games on GameList                            |
| List\<Game\>         | GET         | /api/games/search/{keyword}                    |                                                 | Search by game title                                 |
| List\<Platform\>     | GET         | /api/platforms                                 |                                                 | List of all                                          |
| Platform           | GET         | /api/platforms/{id}                            |                                                 | Retrieve                                             |
| List\<Game\>         | GET         | /api/platforms/{id}/games                      |                                                 | List of games for platform                           |
| List\<Staff\>        | GET         | /api/staff                                     |                                                 | List of all                                          |
| Staff              | GET         | /api/staff/{id}                                |                                                 | Retrieve                                             |
| List\<Game\>         | GET         | /api/staff/{id}/games                          |                                                 | List of games by staff                               |
| List\<Status\>       | GET         | /api/status                                    |                                                 | List of all                                          |
| Status             | GET         | /api/status/{id}                               |                                                 | Retrieve                                             |

## Technologies Used
Angular, Angular CLI, Hibernate, Spring Boot, Spring Data JPA, Spring Tool Suite 4, Postman, Java 8, Gradle, JUnit 5, MAMP, SQL (MySQL), Git terminal, MAC OS, MySQL Workbench

## Things That Can Be Done Better (at the moment)
- Consistency in URI with regards to capitalization
- A UI design direction

## Lessons Learned (at the moment)
- Start smaller with service objects:
<br>
It would've helped me greatly to have started on smaller object to fully-implement CRUD operations as a template, rather then spending my time with completing so much of the relationships with the main table `Game`.
<br>
<br>

- A Plan With Angular:
<br>
While this is a brand-new technology I am still learning and tinkering with, I would say that from the onset it is important to have an idea of all the pieces to a page that are desired. Such as where an error should show, or even just how to handle/create these on the front-end. I'm finding that I prefer to almost start from scratch after prototyping a page and build it from the top down.

## Basic Angular Front-End
![Angular Front-End](https://drive.google.com/uc?export=view&id=16cHogyoVIYbtbXCL2xz3Cd9mAe8coU01)

## Database Schema
![Database Schema](https://drive.google.com/uc?export=view&id=1NkOGlh_AphY1Ze4anoymngzl9j3nBTPr)
