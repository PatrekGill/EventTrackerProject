console.log("script.js loaded");

function init() {
    console.log("Init Executed");
    addSearchEvent();
}

window.addEventListener("load",function(event) {
    console.log("document loaded");
    init();
});


var searchForGamesFunction = function(event) {
    event.preventDefault();
    console.log("searched");

    let searchValue = document.getElementById("searchInput").value;
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET",`api/games/search/${searchValue}`);
    xhr.onreadystatechange = function() {
        console.log("state change");
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log("Request Good");
                let games = JSON.parse(xhr.responseText);
                console.log(games);

            } else {
                console.log("Request bad");
                console.log(xhr.status);
            }
        }
    };

    xhr.send();
}

function addSearchEvent() {
    let searchButton = document.getElementById("searchButton");
    searchButton.addEventListener("click",searchForGamesFunction);
}