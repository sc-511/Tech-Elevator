let user;
let accounts;
let transferUsers;
let transferHistory;

document.addEventListener('DOMContentLoaded',()=>{
    const loginButton = document.getElementById('btnLogin');
    loginButton.addEventListener('click',(event) => {
        event.preventDefault();
        const userData = {
            username: document.getElementById('username').value.trim(),
            password:document.getElementById('password').value.trim()
        };
        login(userData)
    });
    
    const registerButton = document.getElementById('btnRegister');
    registerButton.addEventListener('click',(event) => {
        event.preventDefault();
        const userData = {
            username: document.getElementById('registerName').value.trim(),
            password:document.getElementById('registerPassword').value.trim()
        };
        register(userData)
    })

    const userButton = document.getElementById('users');
    userButton.addEventListener('click',(event) => {
        users();
    });

    const balanceButton = document.getElementById('balance');
    balanceButton.addEventListener('click',(event) => {
        getBalance(true);
    })
    if(!user)
    {
        document.getElementById('loggedOut').classList.remove('hide');
        document.getElementById('mainApp').classList.add('hide');
    }

    const amountText = document.getElementById('amount');
    amountText.addEventListener('change',(event) => {
        if(transferReadyStatus())
        {
            amountText.classList.remove('error');
        } else {
            amountText.classList.add('error');
        }
    })

    const transferButton = document.getElementById('maketransfer');
    transferButton.addEventListener('click',(event) => {
        const transferObject = {
            accountTo: selectedAccount(),
            accountFrom: accounts[0].accountId,
            amount: amountText.value
        };
        transfer(transferObject);
    })

    const transferHistoryButton = document.getElementById('transferHistory');
    transferHistoryButton.addEventListener('click',(event) => {
        getTransfers();
    })

})

function transferReadyStatus()
{
    if(!enoughMoney() || selectedAccount() < 0)
    {
        document.getElementById('maketransfer').disabled = true;
        return false;
    } else {
        document.getElementById('maketransfer').disabled = false;
        document.getElementById('amount').classList.remove('error');
        return true;
    }
}

function displayBalance()
{
    if(accounts)
    {
        document.getElementById('balanceDisplay').innerText = `Balance is ${calculateBalance()}`;
    }
}

function calculateBalance(){
    let totalBalance = accounts.reduce((sum,account) => {
        return sum += account.balance;
    },0)
    return totalBalance;
}

function displayTransferUsers()
{
    if(transferUsers)
    {
        const tableBody = document.getElementById('userbody');
        tableBody.innerText = '';
        transferUsers.forEach((tUser) => {
            const row = document.createElement('tr');
            const idCell = document.createElement('td');
            const radioCell = document.createElement('td');
            const nameCell = document.createElement('td');
            idCell.innerText = tUser.accountId;
            nameCell.innerText = tUser.userName;
            radioCell.innerHTML = "<input type='radio' name='accountTo' value='" + tUser.accountId + "'/>"
            row.appendChild(radioCell);
            row.appendChild(idCell);
            row.appendChild(nameCell);
            tableBody.appendChild(row);
        })

        // need to add the event Handlers
        const accountRadioButtons = document.querySelectorAll('input[name="accountTo"]');
        accountRadioButtons.forEach((rButton) => {
            rButton.addEventListener('change',(event) => {
                transferReadyStatus();
            })
        })
    
    }
}

function displayTransfers()
{
    if(transferHistory)
    {
        const tableBody = document.getElementById('transferBody');
        tableBody.innerText = '';
        transferHistory.forEach((history) => {
            const row = document.createElement('tr');
            const radioCell = document.createElement('td');
            const idCell = document.createElement('td');
            const fromCell = document.createElement('td');
            const toCell = document.createElement('td');
            const amountCell = document.createElement('td');
            idCell.innerText = history.transferId;
            fromCell.innerText = history.from;
            toCell.innerText = history.to;
            amountCell.innerText = history.amount;
            radioCell.innerHTML = "<input type='radio' name='transfer' value='" + history.transferId + "'/>"
            row.appendChild(radioCell);
            row.appendChild(idCell);
            row.appendChild(fromCell);
            row.appendChild(toCell);
            row.appendChild(amountCell);
            tableBody.appendChild(row);
        })

        // need to add the event Handlers
        const transferRadioButtons = document.querySelectorAll('input[name="transfer"]');
        transferRadioButtons.forEach((rButton) => {
            rButton.addEventListener('change',(event) => {
                showTransferDetail(rButton.value);
            })
        })
    
    }
}

function showTransferDetail(transferId)
{
    const tDetail = document.getElementById('transferDetail');
    tDetail.classList.remove('hide');
    let transferToDisplay = transferHistory.find((tx) => {
        return tx.transferId == transferId;
    })
    console.log(transferToDisplay);
    for(let key in transferToDisplay)
    {
        const paragraph = document.createElement('p');
        paragraph.innerText = key +": " + transferToDisplay[key];
        tDetail.appendChild(paragraph);
    }
}
function enoughMoney()
{
    return document.getElementById('amount').value <= calculateBalance();
}

function selectedAccount()
{
    const radioButtons = Array.from(document.querySelectorAll('input[name="accountTo"]'));
    for(let i = 0; i < radioButtons.length; i++)
    {
        if(radioButtons[i].checked)
        {
            return radioButtons[i].value;
        }
    }
    return -1;
}