let query = 'https://api.nasa.gov/planetary/apod?api_key=6MuLtINdSjdvIePOfN9UG34oOeR24MwJ8oUbQ8LI';
let request = new XMLHttpRequest();
request.open('GET', query);
request.onload = function () {
    if (request.status === 200) {
        let response = JSON.parse(request.responseText);
        document.getElementById('img-of-the-day').setAttribute('src', response.url);
    }
};
request.send();