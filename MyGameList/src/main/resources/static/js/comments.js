function postComment() {

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
    
}