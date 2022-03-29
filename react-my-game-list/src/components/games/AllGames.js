import { useCallback, useContext, useEffect, useState } from "react";
import UrlContext from "../../context/url-context";
import Game from "./Game";

const AllGames = (props) => {
    const urlCtx = useContext(UrlContext);

    const [games, setGames] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    const fetchGamesHandler = useCallback(async () => {
        console.log("fetching games...");
        setIsLoading(true);
        setError(null);

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

    const gamesList = games.map((game) => <Game key={game.id} game={game} />);

    return (
        <div className="container chart-contianer">
            <div className="row row-cols-1 row-cols-sm-1 row-cols-lg-2 row-cols-xl-3 row-cols-xxl-4 g-5">
                {isLoading && <p>Loading...</p>}
                {!isLoading && !error && gamesList}
                {error && <p>{error}</p>}
            </div>
        </div>
    );
};

export default AllGames;
