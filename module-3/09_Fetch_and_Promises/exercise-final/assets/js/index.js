// When the page loads the items will not be loaded. I am using this variable
// to track when the items get loaded so I can 'disable' the button
let itemsLoaded = false;
const loadingButton = document.querySelector('.loadingButton');

loadingButton.addEventListener("click",() => {
  // only call load groceries if the items aren't loaded. Once they are loaded
  // we shouldn't keep calling this method.
  if( !itemsLoaded ) {
    loadGroceries();
  }
});

function loadGroceries() {
  fetch('assets/data/shopping-list.json')
  .then((response) => {
    return response.json();
  })
  .then((groceries) => {
    if('content' in document.createElement('template')) {
      const list = document.querySelector("ul");
      groceries.forEach((item) => {
        const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
        tmpl.querySelector("li").insertAdjacentHTML('afterbegin',item.name);
        if( item.completed ) {
          const circleCheck = tmpl.querySelector('.fa-check-circle');
          circleCheck.className += " completed";
        }
        list.appendChild(tmpl);
      });
      // update our items loaded to be true so we don't keep loading them.
      itemsLoaded = true;
    } else {
      console.error('Your browser does not support templates');
    }
  })
  .catch((err) => {console.error(err)});
}

