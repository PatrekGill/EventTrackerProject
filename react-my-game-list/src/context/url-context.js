import React from "react";

const baseUrl = "http://localhost:8083/";
const restBaseEndpoint = baseUrl + "api/";
const gameBase = restBaseEndpoint + "games/";

const UrlContext = React.createContext({
    baseURL: baseUrl,
    apiBaseURL: restBaseEndpoint,
    gameApiBaseURL: gameBase,
});

export default UrlContext;
