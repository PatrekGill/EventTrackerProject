console.log("script.js loaded");

function addSearchEvent() {
    let searchButton = document.getElementById("searchButton");
    searchButton.addEventListener("click",searchForGamesFunction);
    let searchBar = document.getElementById("searchInput");
    searchBar.addEventListener("keydown",(event) => {
        if (event.key === "Enter") {
            searchForGamesFunction(event);
        }
    });
}

function init() {
    console.log("Init Executed");
    addSearchEvent();
}

window.addEventListener("load",function(event) {
    console.log("document loaded");
    init();
});

