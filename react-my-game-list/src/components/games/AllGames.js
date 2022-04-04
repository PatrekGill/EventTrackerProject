import Game from "./Game";

const AllGames = (props) => {
    const editingGameHandler = (game) => {
		props.editingGame(game);
	};
	const deleteGameHandler = (game) => {
		props.deleteGame(game);
	};
	
	const gamesList = props.games.map((game) => (
        <Game 
			key={game.id} 
			game={game} 
			editingGame={editingGameHandler}
			deleteGame={deleteGameHandler}
		/>
    ));

    return (
        <div className="container chart-contianer">
            <div className="row row-cols-1 row-cols-sm-1 row-cols-lg-2 row-cols-xl-3 row-cols-xxl-4 g-5">
                {gamesList}
            </div>
        </div>
    );
};

export default AllGames;
