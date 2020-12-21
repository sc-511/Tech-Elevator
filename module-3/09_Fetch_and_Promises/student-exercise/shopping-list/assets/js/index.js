document.addEventListener('DOMContentLoaded', () =>{
    const unorderedList = document.querySelector("ul");
    const loadingButton = document.querySelector(".loadingButton");
    loadingButton.addEventListener('click', (event) =>{
        const shoppingListAPI = 'https://techelevator-pgh-teams.azurewebsites.net/api/techelevator/shoppinglist';
        fetch (shoppingListAPI)
        .then((response) =>{
            return response.json();
        })
        .then((data) =>{
            let groceries = data ;
            groceries.forEach((item) =>{
                const shoppingListTemplate = document.getElementById('shopping-list-item-template').content.cloneNode(true);
                shoppingListTemplate.querySelector('li').innerText = item.name;
                const buttonValue = shoppingListTemplate.querySelector('i');
                if(item.completed === true){
                    //able to see the code is able to find the value of completed in the array
                   console.log("completed items");
                   //produces a null value when the tag exists in html? 
                   //buttonValue.setAttribute('class', 'far fa-check-circle');
                   //does not help with the production of the null value
                   //shoppingListTemplate.querySelector('li').appendChild(buttonValue);
                } else{
                    console.log("non completed items");
                    
                }
                unorderedList.appendChild(shoppingListTemplate);
            });
            
        })
        .catch((err) =>{
            console.error(err);
        });
    });
});