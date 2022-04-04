import { useContext, useState } from "react";
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
	
	
    const floatingFormClass = "form-floating";
    const textFieldClass = `${floatingFormClass} ${classes.textField}`;
    const textAreaClass = `form-control ${classes.textAreaField}`;
	
    let gameTitle,
	gameDescription,
	gameImage = "";
	const gameBeingEdited = props.game;
    if (gameBeingEdited) {
		gameTitle = gameBeingEdited.title;
		gameDescription = gameBeingEdited.description;
		gameImage = gameBeingEdited.imageURL;
		
    }
	const [editGameTitle,setEditGameTitle] = useState(gameTitle);
	const [editGameDescription,setEditGameDescription] = useState(gameDescription);
	const [editGameImage,setEditGameImage] = useState(gameImage);

    const [error, setError] = useState(null);
    const submitGameHandler = async () => {
        setError(null);

        const game = {
            title: editGameTitle,
            description: editGameDescription,
            imageURL: editGameImage,
        };

		let method = "POST";
		let url = urlCtx.gameApiBaseURL;
		if (gameBeingEdited) {
			url = url + gameBeingEdited.id;
			method = "PUT";
		}


        try {
            const response = await fetch(url, {
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
        } catch (error) {
            setError(error.message);
        }
    };

	
    const closeHandler = () => {
        props.onClose();
    };

	const changeTitleHandler = (event) => {
		setEditGameTitle(event.target.value);
	};
	const changeDescriptionHandler = (event) => {
		setEditGameDescription(event.target.value);
	};
	const changeImageHandler = (event) => {
		setEditGameImage(event.target.value);
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
						onChange={changeTitleHandler}
						value={editGameTitle}
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
						onChange={changeDescriptionHandler}
						value={editGameDescription}
                    />
                    <label htmlFor="descriptionEdit">Description</label>
                </div>
                <br />
                <div className={textFieldClass}>
                    <input
                        type="text"
                        className="form-control"
                        id="imageEdit"
                        placeholder="URL"
						onChange={changeImageHandler}
						value={editGameImage}
                    />
                    <label htmlFor="imageEdit">Image URL</label>
                </div>
            </ModalBody>

            <ModalFooter style={{ display: "block" }}>
				<Button onClick={submitGameHandler}>
					{
						gameBeingEdited ? "Update Game" : "Add Game"
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
