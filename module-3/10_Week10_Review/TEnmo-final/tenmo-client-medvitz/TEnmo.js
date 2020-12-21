let token;
let user;

document.addEventListener('DOMContentLoaded', () => {
    const loginBtn = document.getElementById("btnLogin");
    loginBtn.addEventListener('click', (event) => {
        event.preventDefault();
        let u = document.getElementById("username").value.trim();
        let p = document.getElementById("password").value.trim();

        let loginDTO = {
            username : u,
            password : p
        };

        fetch('http://localhost:8080/login', {
            method : "POST",
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(loginDTO)
        })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            token = data.token;
            user = data.user;

            document.getElementById("loggedOut").classList.add("hide");
            document.getElementById("mainApp").classList.remove("hide");            
        })
        .catch((err) => {
            console.error(err);
        });
    });

    const getBalanceBtn = document.getElementById("balance");
    getBalanceBtn.addEventListener('click', () => {
        fetch("http://localhost:8080/account/balance", {
            method: 'GET',
            headers: {
                'Content-Type' : 'application/json',
                'Authorization' : 'Bearer ' + token
            }
        })
        .then((response) => { return response.json(); } )
        .then((data) => {
            document.getElementById("balanceDisplay").innerText = data;
            user.balance = data;
        })
        .catch((err) => {
            console.error(err);
        });
    });

    const getUsersForTxBtn = document.getElementById("users");
    getUsersForTxBtn.addEventListener('click', () => {
        fetch('http://localhost:8080/users', {
            method: 'GET',
            headers: {
                'Content-Type' : 'application/json',
                'Authorization' : 'Bearer ' + token
            }
        })
        .then((response) => { return response.json(); })
        .then((data) => {
            document.getElementById("transferStepOne").classList.remove("hide");
            const table = document.getElementById("userbody");
            table.innerHTML = '';

            data.forEach((u) => {
                if(user.id !== u.id) {
                    const newRow = document.createElement('tr');

                    const idCell = document.createElement('td');
                    const radioCell = document.createElement('td');
                    const nameCell = document.createElement('td');

                    //idCell.innerText = u.id;
                    radioCell.innerHTML = '<input type="radio" name="accountTo" value="' + u.id + '" >';
                    radioCell.addEventListener("change", transferReadyStatus);
                    
                    nameCell.innerText = u.username;

                    newRow.appendChild(idCell);
                    newRow.appendChild(radioCell);
                    newRow.appendChild(nameCell);

                    table.appendChild(newRow);
                }
            });
        })
        .catch((err) => {
            console.error(err);
        });
    });

    document.getElementById("amount").addEventListener('change', () => {
        transferReadyStatus();
    });

});


function transferReadyStatus() {
    if(selectedAccount() !== -1 && hasEnoughMoney()) {
        document.getElementById("maketransfer").disabled = false;
    } else {
        document.getElementById("maketransfer").disabled = true;
    }
}

function hasEnoughMoney() {
    return user.balance > document.getElementById("amount").value && document.getElementById("amount").value > 0;
}

function selectedAccount() {
    const radioButtons = document.querySelectorAll('input[name="accountTo"]');
    let selectedButton = -1;
    radioButtons.forEach((button) => {
        if(button.checked) {
            selectedButton = button.value;
        }
    });

    return selectedButton;
}