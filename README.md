# EventTrackerProject

## Overview

### REST API

### HTML/JavaScript Front End

### Angular Front End

## REST API Reference
| Return Type       | HTTP Method | URI                                            | Request Body                                     | Purpose                             |
|-------------------|-------------|------------------------------------------------|--------------------------------------------------|-------------------------------------|
| List<Company>     | GET         | /api/companies                                 |                                                  | List of all                         |
| Company           | GET         | /api/companies/{id}                            |                                                  | Retrieve                            |
| List<GameCompany> | GET         | /api/companies/{id}/gameroles                  |                                                  | List of company games with roles    |
| List<Game>        | GET         | /api/companies/{id}/games                      |                                                  | List of company games without roles |
| List<Company>     | GET         | /api/companies/search/{name}                   |                                                  | Search by name                      |
| List<Company>     | GET         | /api/companies/search/{name}/{numberOfEntries} |                                                  | Search by name, limit return        |
| GameComment       | GET         | /api/GameComment/{id}                          |                                                  | Retrieve                            |
| List<GameComment> | GET         | /api/GameComment/{id}/replies                  |                                                  | Get replies to comment              |
| GameComment       | GET         | /api/GameComment/{id}/replyTo                  |                                                  | Get comment that was replied to     |
| GameComment       | POST        | /api/GameComment                               | GameComment (Required entries: text, game, user) | Create comment                      |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |
|                   |             |                                                |                                                  |                                     |

## Technologies Used
Spring MVC, Hibernate, Spring Boot, Spring Data JPA, Spring Tool Suite 4, Postman, Java 8, Gradle

## Lessons Learned
