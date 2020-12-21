document.addEventListener('DOMContentLoaded', () => {

    const movie = document.getElementById('movie');
    const btnSearch = document.getElementById('btnSearch');
    btnSearch.addEventListener('click', () => {
        fetch({
            url: 'https://github.com/public-apis/public-apis',
            method: 'POST',
            'Content-Type': 'application/json'
        })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            const movieData = document.getElementById('movieData');

            data.Search.forEach((movieObject) => {
                const newRow = buildRow(movieObject);
                movieData.append(newRow);
            });
        })
        .catch((err) => {
            console.error(err);
        });

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
