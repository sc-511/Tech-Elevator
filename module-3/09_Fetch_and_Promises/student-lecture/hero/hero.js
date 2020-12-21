document.addEventListener('DOMContentLoaded', () => {
    const nerdButton = document.getElementById('nerdButton');
    const randomButton = document.querySelector('#randomButton');
    const messageBox = document.querySelector('h4');

    nerdButton.addEventListener('click', (e) => {
        const chuckURL = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
        const kanyeURL = 'https://api.kanye.rest/?format=text';

        fetch(kanyeURL)
        .then((response) => {
            return response.text(); 
        })
        .then((data) => {
//            messageBox.innerText = data.value.joke;
            messageBox.innerText = data;
        })
        .catch((err) => {
            console.error(err);
        });
    });

    randomButton.addEventListener('click', (e) => {
        const chuckURL = 'http://api.icndb.com/jokes/random?exclude=explicit';

        fetch(chuckURL)
        .then((response) => {
            return response.json(); 
        })
        .then((data) => {
            messageBox.innerText = data.value.joke;
        })
        .catch((err) => {
            console.error(err);
        });
    });

});