import { Button } from "react-bootstrap";
import { Fragment, useState, useCallback, useContext, useEffect } from "react";
import UrlContext from "../../context/url-context";

import AllGames from "./AllGames";
import GameModal from "./GameModal";

const GameList = () => {
    const urlCtx = useContext(UrlContext);

    const [games, setGames] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);
    const [editGame, setEditGame] = useState(null);

    const fetchGamesHandler = useCallback(async () => {
        console.log("fetching games...");
        setIsLoading(true);
        setError(null);
        setEditGame(null);

        try {
            const response = await fetch(urlCtx.gameApiBaseURL);
            if (!response.ok) {
                throw new Error("Could not retrieve games list!");
            }

            const data = await response.json();
            setGames(data);
            setIsLoading(false);
            console.log("Games fetched");
        } catch (error) {
            setIsLoading(false);
            setError(error.message);
            console.error("Games NOT Fetched");
        }
    }, [urlCtx]);

    // load once on page start
    useEffect(() => {
        fetchGamesHandler();
    }, [fetchGamesHandler]);

    const [editingGame, setEditingGame] = useState(false);
    const openEditGame = () => {
        setEditingGame(true);
    };
    const closeEditGameHandler = () => {
        setEditingGame(false);
        setEditGame(null);
    };
    const gameEditedHandler = () => {
        setEditingGame(false);
        setEditGame(null);
        fetchGamesHandler();
    };
    const editingGameHandler = (game) => {
        setEditGame(game);
        setEditingGame(true);
    };

    const deleteGameHandler = async (game) => {
        const id = game.id;

        try {
            const url = urlCtx.gameApiBaseURL + id;
            const response = await fetch(url, {
                method: "DELETE",
            });

            if (!response.ok) {
                console.log(response);
                throw new Error("An error occurred while deleting the game...");
            }

			fetchGamesHandler();
        } catch (error) {
            setError(error.message);
        }
    };

    return (
        <div>
            <Button onClick={openEditGame}>Add Game</Button>

            {isLoading && <p>Loading...</p>}
            {!isLoading && !error && (
                <AllGames
                    games={games}
                    editingGame={editingGameHandler}
                    deleteGame={deleteGameHandler}
                />
            )}
            {error && <p>{error}</p>}

            {editingGame && (
                <GameModal
                    onClose={closeEditGameHandler}
                    onEditGame={gameEditedHandler}
                    game={editGame}
                ></GameModal>
            )}
        </div>
    );
};

export default GameList;
