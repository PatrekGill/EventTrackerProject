function createPostCommentForm() {
    const postDiv = document.getElementById("postCommentDiv");
    clearChildren(postDiv);

    const commentPostForm = document.createElement("form");
    commentPostForm.name = "commentPostForm";

    const textInput = document.createElement("textArea");
    textInput.name = "commentTextInput";
    textInput.rows = "4";
    textInput.placeholder = "Type something...";
    textInput.classList.add("postCommentTextArea");
    
    const postButton = document.createElement("button");
    postButton.textContent = "Post Comment";
    postButton.addEventListener("click",postCommentEvent);

    commentPostForm.appendChild(textInput);
    commentPostForm.appendChild(postButton);
    postDiv.appendChild(commentPostForm);
}

function getCurrentGame() {
    return document.getElementById("gameDetailsDiv").game;
}

var postCommentEvent = function(event) {
    event.preventDefault();
    const gameId = getCurrentGame().id;
    const commentText = document.commentPostForm.commentTextInput.value;
    if (commentText == "") {
        return;
    }

    const game = {
        "id" : gameId
    };
    const user = {
        "id" : 1
    };
    const gameComment = {
        "user" : user,
        "game" : game,
        "text" : commentText
    };
    const gameCommentJSON = JSON.stringify(gameComment);

    let xhr = new XMLHttpRequest();
    xhr.open("POST",`api/GameComment`);
    xhr.setRequestHeader("Content-type","application/json");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                console.log("Post Success");
                getCommentsForGame(getCurrentGame().id)

            } else {
                console.log("Post failed!");
                console.log(xhr.status);

            }
        }
    };

    
    xhr.send(gameCommentJSON);
}

var updateCommentEvent = function(event) {
    event.preventDefault();
    const gameComment = event.target.parentElement.parentElement.comment;
    
    gameComment.text = document.getElementById("editTextInput_" + gameComment.id);
    const gameCommentJSON = JSON.stringify(gameComment);

    let xhr = new XMLHttpRequest();
    xhr.open("PUT",`api/GameComment/${gameComment.id}`);
    xhr.setRequestHeader("Content-type","application/json");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log("update Success");
                // const button = event.target;
                // button.textContent = "Edit";
                // button.removeEventListener("click",updateCommentEvent);
                // button.addEventListener("click",editCommentButtonEvent)
                getCommentsForGame(getCurrentGame().id)

            } else {
                console.log("update failed!");
                console.log(xhr.status);

            }
        }
    };

    
    xhr.send(gameCommentJSON);
}



function getCommentsForGame(gameId) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET",`api/games/${gameId}/comments`);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // console.log("Request Good");
                let comments = JSON.parse(xhr.responseText);
                displayComments(comments);

            } else {
                console.log("Request bad");
                console.log(xhr.status);
            }
        }
    };

    xhr.send();
}


var deleteCommentEvent = function(event) {
    const commentId = event.target.parentElement.parentElement.comment.id;
    const xhr = new XMLHttpRequest();
    xhr.open("DELETE",`api/GameComment/${commentId}`);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 204) {
                // console.log("Request Good");
                getCommentsForGame(getCurrentGame().id)

            } else {
                console.log("Request bad");
                console.log(xhr.status);
            }
        }
    };

    xhr.send();
}
var editCommentButtonEvent = function(event) {
    const button = event.target;
    button.textContent = "Save";
    button.removeEventListener("click",editCommentButtonEvent);
    button.addEventListener("click",updateCommentEvent)


    const commentTextData = button.parentElement.parentElement.children[0];
    
    const originalText = commentTextData.textContent;
    commentTextData.innerHTML = "";

    const textInput = document.createElement("textArea");
    textInput.id = "editTextInput_" + commentTextData.parentElement.comment.id;
    textInput.textContent = originalText;
    textInput.rows = "5";
    textInput.classList.add("postCommentTextArea");
    commentTextData.appendChild(textInput);


}


function displayComments(comments) {
    const tableBody = document.getElementById("commentTableBody");
    clearChildren(tableBody);

    const tableHeader = document.getElementById("commentTableHeader");
    if (comments.length > 0) {
        const tableDateHeader = document.getElementById("commentTableDateHeader");
        tableDateHeader.textContent = "Date";
        tableHeader.textContent = "Comments:";
        
        for (let index = 0; index < comments.length; index++) {
            const tableRow = document.createElement("tr");
            const comment = comments[index];
            tableRow.id = "gameComment_" + comment.id;
            tableRow.comment = comment;
    
            const tableDataText = document.createElement("td");            
            tableDataText.textContent = comment.text;
            tableDataText.classList.add("commentText");

            const tableDataCreateTime = document.createElement("td");
            const commentDate = new Date(comment.createdDateTime);            
            tableDataCreateTime.textContent = commentDate.toDateString();
            tableDataCreateTime.classList.add("commentDate");

            const tableDataButtons = document.createElement("td");  
            
            const deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";
            deleteButton.addEventListener("click",deleteCommentEvent);
            tableDataButtons.appendChild(deleteButton);

            const editButton = document.createElement("button");
            editButton.textContent = "Edit";
            editButton.addEventListener("click",editCommentButtonEvent);
            tableDataButtons.appendChild(editButton);


            tableRow.appendChild(tableDataText);
            tableRow.appendChild(tableDataCreateTime);    
            tableRow.appendChild(tableDataButtons);        
            tableBody.appendChild(tableRow);
        }

    } else {
        tableHeader.textContent = "No Comments...";
    }
    
    createPostCommentForm();
}