let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}


 


document.addEventListener("DOMContentLoaded", () =>{
  setPageTitle();
  displayGroceries();

  const singleItems = document.querySelector('ul');
  let allItems = [];
  let childrenNodes = [];
  allItems = singleItems.children;
  for(let i = 0; i < allItems.length; i++){
    allItems[i].addEventListener('click', (event) => {
      if(allItems[i].getAttribute('completed') != 'true'){
        allItems[i].setAttribute('class', 'completed');
        childrenNodes = allItems[i].children;
        childrenNodes[0].setAttribute('class', 'far fa-check-circle completed');
      }
    });
    
    allItems[i].addEventListener('dblclick', (event) => {
        if(allItems[i].getAttribute('completed') != 'false'){
          allItems[i].classList.remove('completed');
          childrenNodes = allItems[i].children;
          childrenNodes[0].classList.remove('completed');
          }z
        });
    }
    const toggleButton = document.getElementById('toggleAll');
    if(allItemsIncomplete){
      toggleButton.addEventListener('click', (event) => {
        for(let i = 0; i < allItems.length; i++){
          allItems[i].setAttribute('class', 'completed');
          childrenNodes = allItems[i].children;
          childrenNodes[0].setAttribute('class', 'far fa-check-circle completed');
          !allItemsIncomplete;
          toggleButton.innerText = 'Mark All Incomplete';
          }
        });
      } else {
        toggleButton.addEventListener('dblclick', (event) => {
          for(let i = 0; i < allItems.length; i++){
            allItems[i].classList.remove('completed');
            childrenNodes = allItems[i].children;
            childrenNodes[0].classList.remove('completed');
            allItemsIncomplete;
            toggleButton.innerText = 'Mark All Complete';
            }
          });
      }
});


  // if (allItems.getAttribute('completed') === null){
  //   allItems.addEventListener('click', (event) =>{
  //     allItems.setAttribute('class', 'completed');
  //     itemCheckMark.setAttribute('class', 'far fa-check-circle completed');

  
  //   });
  // } else {
  //   allItems.addEventListener('dbclick', (event) =>{
  //     allItems.classList.removeAttribute('completed');
  //     itemCheckMark.removeAttribute('far fa-check-circle completed');
  //     itemCheckMark.setAttribute('class', "far fa-check-circle");
  //   });
  // }



function MarkAllComplete(){

}

function MarkAllIncomplete(){

}
