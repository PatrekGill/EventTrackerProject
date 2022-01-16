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
    console.log("searched");
}

function addSearchEvent() {
    let searchButton = document.getElementById("searchButton");
    searchButton.addEventListener("click",searchForGamesFunction);
}