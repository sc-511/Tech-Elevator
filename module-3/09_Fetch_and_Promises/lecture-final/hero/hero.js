document.addEventListener('DOMContentLoaded', () => {  

    const nerdButton = document.getElementById('nerdButton');
    const messageBox = document.getElementById('message');

    nerdButton.addEventListener('click', (event) => {
        const kanye = 'https://api.kanye.rest/?format=text';
        const chuckNerd = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
        
        fetch(kanye)
        .then((response) => {
            return response.text();
        })
        .then((data) => {
            const kanyeResponse = data;
            //const chuckResponse = data.value.joke;

            messageBox.innerText = kanyeResponse;
        })
        .catch((err) => {
            console.error(err);
        });
    });

    const randomButton = document.getElementById('randomButton');
    randomButton.addEventListener('click', (event) => {
        const chuckRandom = 'http://api.icndb.com/jokes/random?exclude=explicit';

        fetch(chuckRandom)
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