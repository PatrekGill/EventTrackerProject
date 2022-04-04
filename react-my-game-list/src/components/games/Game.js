import classes from "./Game.module.css";

const Game = (props) => {
    const game = props.game;

	const editingGameHandler = () => {
		props.editingGame(game);
	};
	
    return (
        <div className="col">
            <div className={`${classes["card-container"]} card`}>
                <div className="row">
                    <div className={`${classes["cover-div"]} col-5`}>
                        <img className={classes["card-image"]} src={game.imageURL} alt={`${game.title} cover`} />
                        <div className={`${classes["title-overlay"]}`}>
                            <a href="/" className="card-title">
                                {game.title}
                            </a>
                        </div>
                    </div>

                    <div className={`col-7 ${classes["card-text-column"]}`}>
                        <div className={classes["card-text-div"]}>{game.description}</div>
                    </div>
                </div>

                <div className="card-footer">
                    <button className="btn btn-primary btn-sm" onClick={editingGameHandler}>Edit</button>
                    <span className={classes["card-delete"]}>
                        <button className="btn btn-danger btn-sm">Delete</button>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default Game;
