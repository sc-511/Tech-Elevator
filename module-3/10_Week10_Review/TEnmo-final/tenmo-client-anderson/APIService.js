function login(userData)
{

    fetch('https://localhost:44315/login', {
        method: 'POST',
        body: JSON.stringify(userData),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        user = data;
        // get the user's account balance
        getBalance();
        document.getElementById('loggedOut').classList.add('hide');
        document.getElementById('mainApp').classList.remove('hide');
    })
    .catch((error) => {
        console.error('Error:', error);
    })
    
}

function register(userData)
{

    fetch('https://localhost:44315/login/register', {
        method: 'POST',
        body: JSON.stringify(userData),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        document.getElementById('register').classList.add('hide');

    })
    .catch((error) => {
        console.error('Error:', error);
    })
    
}

function users()
{
    fetch('https://localhost:44315/api/account/users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + user.token
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        transferUsers = data;
        document.getElementById('transferStepOne').classList.remove('hide');
        displayTransferUsers();
    })
    .catch((error) => {
        console.error('Error:', error);
    })
    
}

function transfer(transferObject)
{
    fetch('https://localhost:44315/api/transfer', {
        method: 'POST',
        body: JSON.stringify(transferObject),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + user.token
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        document.getElementById('transferStepOne').classList.add('hide');
    })
    .catch((error) => {
        console.error('Error:', error);
    })

}

function getBalance(shouldShow = false)
{
    fetch('https://localhost:44315/api/account', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + user.token
        }
    })
    .then(response => response.json())
    .then(data => {
        accounts = data;
        if(shouldShow)
        {
            displayBalance();
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    })

}

function getTransfers()
{
    fetch('https://localhost:44315/api/transfer', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + user.token
        }
    })
    .then(response => response.json())
    .then(data => {
        transferHistory = data;
        document.getElementById('transferDisplay').classList.remove('hide');
        displayTransfers();
    })
    .catch((error) => {
        console.error('Error:', error);
    })

}