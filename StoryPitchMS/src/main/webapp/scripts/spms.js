function authorRedirect() {
    let url = 'http://localhost:8080/StoryPitchMS/author';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    xhttp.open('GET', url, true);

    xhttp.send();
}

function editorRedirect() {
    let url = 'http://localhost:8080/StoryPitchMS/editor';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    xhttp.open('GET', url, true);

    xhttp.send();
}