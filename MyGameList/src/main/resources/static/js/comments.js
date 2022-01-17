function createPostCommentForm() {
    const postDiv = document.getElementById("postCommentDiv");
    clearChildren(postDiv);

    const commentPostForm = document.createElement("form");
    commentPostForm.name = "commentPostForm";

    const textInput = document.createElement("textArea");
    textInput.name = "commentTextInput";
    textInput.rows = "4";
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

var postCommentEvent = function postComment(event) {
    event.preventDefault();
    const gameId = getCurrentGame().id;
    const commentText = document.commentPostForm.commentTextInput.value;

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
    
            const tableDataText = document.createElement("td");            
            tableDataText.textContent = comment.text;
            tableDataText.classList.add("commentText");

            const tableDataCreateTime = document.createElement("td");
            let commentDate = new Date(comment.createdDateTime);            
            tableDataCreateTime.textContent = commentDate.toDateString();
            tableDataCreateTime.classList.add("commentDate");

            tableRow.appendChild(tableDataText);
            tableRow.appendChild(tableDataCreateTime);            
            tableBody.appendChild(tableRow);
        }

    } else {
        tableHeader.textContent = "No Comments...";
    }
    
    createPostCommentForm();
}