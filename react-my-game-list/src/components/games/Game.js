import classes from "./Game.module.css";

const Game = (props) => {
    const game = props.game;
    console.log(game);
    return (
        <div className="col">
            <div className={`card ${classes["card-container"]} container`}>
                <div className="row">
                    <div className={`col-5 ${classes["cover-div"]}`}>
                        <img className={classes["card-image"]} src={game.imageURL} alt={`${game.title} cover`} />
                        <div className={`col-5 ${classes["title-overlay"]}`}>
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
                    <button className="btn btn-primary btn-sm">Edit</button>
                    <span className={classes["card-delete"]}>
                        <button className="btn btn-danger btn-sm">Delete</button>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default Game;
