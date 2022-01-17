function displaySearchResults(results) {
    const tableBody = document.getElementById("searchResultsTableBody");
    clearChildren(tableBody);
    
    for (let i = 0; i < results.length; i++) {
        const game = results[i];

        const tableRow = document.createElement("tr");
        tableRow.id = "searchResult_game_" + game.id;

        const tableData = document.createElement("td");
        
        const link = document.createElement("a");
        link.game = game;
        link.href = "";
        link.textContent = game.title;
        addGameLinkClickEvent(link);

        tableData.appendChild(link);
        tableRow.appendChild(tableData);
        tableBody.appendChild(tableRow);
    }
}

var searchForGamesFunction = function(event) {
    event.preventDefault();

    const searchValue = document.getElementById("searchInput").value;
    
    const xhr = new XMLHttpRequest();
    xhr.open("GET",`api/games/search/${searchValue}`);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log("Request Good");
                let games = JSON.parse(xhr.responseText);
                displaySearchResults(games);

            } else {
                console.log("Request bad");
                console.log(xhr.status);
            }
        }
    };

    xhr.send();
}



function addGameLinkClickEvent(tag) {
    tag.addEventListener("click",displayGameDetailsfunction);
}


var displayGameDetailsfunction = function displayGameDetails(event) {
    event.preventDefault();
    const gameDetailsDiv = document.getElementById("gameDetailsDiv");
    clearChildren(gameDetailsDiv);

    const titlePara = document.createElement("p");
    gameDetailsDiv.appendChild(titlePara);
    const game = event.target.game;
    titlePara.textContent = `Title: ${game.title}`;
    
    const descriptionPara = document.createElement("p");
    gameDetailsDiv.appendChild(descriptionPara);
    descriptionPara.textContent = `Description: ${game.description}`;

    const gameImageUrl = game.imageURL;
    if (gameImageUrl != null) {
        const image = document.createElement("img");
        gameDetailsDiv.appendChild(image);
        image.src = gameImageUrl;
        console.log(game.imageURL);
    }

    getCommentsForGame(game.id);
    
}

