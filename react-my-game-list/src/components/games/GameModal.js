import { useRef, useContext, useState } from "react";
import {
    Button,
    Modal,
    ModalBody,
    ModalFooter,
    ModalHeader,
} from "react-bootstrap";
import UrlContext from "../../context/url-context";

import classes from "./GameModal.module.css";

const GameModal = (props) => {
    const urlCtx = useContext(UrlContext);
	const [addingNewGame,setAddingNewGame] = useState();

    const floatingFormClass = "form-floating";
    const textFieldClass = `${floatingFormClass} ${classes.textField}`;
    const textAreaClass = `form-control ${classes.textAreaField}`;

    let gameTitle,
        gameDescription,
        gameImage = "";

	const editGame = props.game;
    if (editGame) {
		// setAddingNewGame(false);
		gameTitle = editGame.title;
		gameDescription = editGame.description;
		gameImage = editGame.imageURL;

    } else {
		// setAddingNewGame(true);
	}

    const titleRef = useRef(gameTitle);
    const descriptionRef = useRef(gameDescription);
    const imageRef = useRef(gameImage);

    const resetRefs = () => {
        titleRef.current.value = "";
        descriptionRef.current.value = "";
        imageRef.current.value = "";
    };

    const [error, setError] = useState(null);

    const submitGameHandler = async () => {
        setError(null);

        const game = {
            title: titleRef.current.value,
            description: descriptionRef.current.value,
            imageURL: imageRef.current.value,
        };

		let method = "PUT";
		if (addingNewGame) {
			method = "POST";
		}

        try {
            const response = await fetch(urlCtx.gameApiBaseURL, {
                method: method,
                body: JSON.stringify(game),
                headers: {
                    "Content-Type": "application/json",
                },
            });

            if (!response.ok) {
                console.log(response);
                throw new Error("An error occurred while creating the game...");
            }

            props.onEditGame();
            resetRefs();
        } catch (error) {
            setError(error.message);
        }
    };

	
    const closeHandler = () => {
        resetRefs();
        props.onClose();
    };

    return (
        <Modal size="lg" show={true}>
            <ModalHeader>
                <div className={textFieldClass}>
                    <input
                        type="text"
                        className="form-control"
                        id="titleEdit"
                        placeholder="Title"
                        ref={titleRef}
                    />
                    <label htmlFor="titleEdit">Title</label>
                </div>
            </ModalHeader>

            <ModalBody>
                <div className="form-floating">
                    <textarea
                        rows={5}
                        type="text"
                        className={textAreaClass}
                        style={{ height: "100%" }} // show the 5 rows initially
                        id="descriptionEdit"
                        placeholder="Description"
                        ref={descriptionRef}
                    ></textarea>
                    <label htmlFor="descriptionEdit">Description</label>
                </div>
                <br />
                <div className={textFieldClass}>
                    <input
                        type="text"
                        className="form-control"
                        id="imageEdit"
                        placeholder="URL"
                        ref={imageRef}
                    />
                    <label htmlFor="imageEdit">Image URL</label>
                </div>
            </ModalBody>

            <ModalFooter style={{ display: "block" }}>
				<Button onClick={submitGameHandler}>
					{
						addingNewGame ? "Add Game" : "Update Game"
					}
				</Button>

                <span className={classes["closeButton-span"]}>
                    <Button variant="warning" onClick={closeHandler}>
                        Close
                    </Button>
                </span>
            </ModalFooter>
            {error && <p>error.message</p>}
        </Modal>
    );
};

export default GameModal;
