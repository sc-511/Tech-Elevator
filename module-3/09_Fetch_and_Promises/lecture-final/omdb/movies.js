document.addEventListener('DOMContentLoaded', () => {
    const searchButton = document.getElementById('btnSearch');
    const searchBox = document.getElementById('movie');
    const apikey = 'GET YOUR OWN!';

    const handlerFunction = () => {
        fetch('http://www.omdbapi.com/?apikey=' + apikey + '&s=' + searchBox.value)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            const movieData = document.getElementById('movieData');
            movieData.innerHTML = '';
            data.Search.forEach((movie) => {
                const newRow = buildRow(movie);
                movieData.append(newRow);
            });
        })
        .catch((error) => {
            alert('Errors!');
            console.log(error);
        })
    };
    
    searchButton.addEventListener('click', handlerFunction);
    searchBox.addEventListener('keyup', (event) => {
        console.log(event.key);
        if(event.key === 'Enter') {
            handlerFunction();
        }
    });
});

function buildRow(data) {
    const tr = document.createElement('tr');

    const posterCell = document.createElement('td');
    const imdbCell = document.createElement('td');
    const nameCell = document.createElement('td');
    const yearCell = document.createElement('td');
    const img = document.createElement('img');

    imdbCell.innerText = data.imdbID;
    nameCell.innerText = data.Title;
    yearCell.innerText = data.Year;

    img.src = data.Poster;
    img.setAttribute('class','img-responsive');
    img.setAttribute('class','img-thumbnail');

    posterCell.setAttribute('class','col-sm-2');
    posterCell.append(img);

    tr.append(posterCell);
    tr.append(imdbCell);
    tr.append(nameCell);
    tr.append(yearCell);

    return tr; 
};
