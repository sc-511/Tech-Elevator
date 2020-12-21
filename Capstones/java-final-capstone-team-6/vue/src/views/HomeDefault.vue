/* view of the home page from a user who is not logged in */
<template>
    <div class="box">
        <div class="jumbotron jumbotron-fluid shadow">
            <h1>Comic League!</h1>
            <p>Track your collection! Share with your friends!</p>
        </div>

        <div class="row shadow">
             <h4 class="col-md-12">Featured Collections:</h4>
                <ul class="col-md-3" v-for="collection in collections" v-bind:key="collection.collectionId">
           <li class="card" v-on:click="toCollection(collection.collectionName, collection.collectionDescription, collection.collectionId)"><!-- --------calls method to push router to collection.vue when card is clicked ------- -->
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{collection.collectionName}}</p>  
            </li>
        </ul>
        </div>
          <span>
            <div class="row">
              <h4 class="col-md-12"> Comics: </h4>
              <input v-model="comicTitle" type="search" class="form-control col-md-9" placeholder="Search by Issue Name" name="q">
              <button class="btn btn-dark col-md-2" v-on:click="searchComics(comicTitle)">Search</button> 
                <ul class="col-md-4" v-for="comic in comics.data.results.slice(0,comicsToShow)" v-bind:key="comic.title" >
                    <li class="card">
                        <img class="card-img-top"  v-bind:src="comic.thumbnail.path + '.' + comic.thumbnail.extension">
                        <p class="card-title">{{comic.title}}</p>
                        <div class="btn btn-dark" v-on:click="viewComicDetails(comic.id)">View Comic Details</div>
                    </li>
                </ul>
                
                <button class="btn btn-success col-md-2 btn-lg" v-on:click="showMore()" v-if="!readMore"> View More </button>
                <button class="btn btn-success col-md-2 btn-lg" v-on:click="showLess()" v-if="readMore"> View Less </button>
            </div>
          </span>
      </div>
</template>

<script>
import ComicServices from '../services/ComicServices.js'
import CollectionService from '../services/CollectionService'

export default {
    name: "viewer",
  data(){
        return{
            comicTitle: '',
            comics: {
                data:{}
            },
            comic:{
                comicId:'',
                comicName:'',
                comicCharacters:'',
                authorName:'',
                datePublished:''
            },
            readMore: false,
            comicsToShow: 12,
        }
    },
  methods: {
        searchComics(title) {
            ComicServices.getComicsByName(title).then(response => {
                this.comics = response.data;
                this.comicTitle = '';
            })
        },
        viewComicDetails(comicId){
          this.$store.state.comic.comicId = comicId;
          this.$router.push(`/comic`)
        },
        viewMoreComics(){
          
        },
        showMore(){
          this.readMore = true;
          this.comicsToShow +=39;
        },
        showLess(){
         this.readMore = false;
         this.comicsToShow -= 39;
        }
  },
  created() {
       
        ComicServices.getComicIssue().then(response => {
      this.comics = response.data
        });
        CollectionService.getAllCollections().then(response => {
          this.collections = response.data
        });
    },
    
}
</script>

<style scoped>
.comics{
  width: 100%;
  margin: auto;
  padding: 10px auto;
}

.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
}
div.row {
  background-color:rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: 15px auto;
  padding: 0px;
  border: white solid 6px;
}
.col-md-12 {
  background-color: white;
  padding: 10px 10px 5px;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
div.col-md-2{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
  font-kerning: none;
}

.btn.col-md-2{
  margin: 20px auto;
  padding: 0px;
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
  font-kerning: none;
  width: fit-content;
}
.btn.btn-success.col-md-12{
  width: fit-content;
}

div p.row {
  width: 100%;
  height: 30px;
  display: block;
  border-top: darkgrey solid 1px;
  padding: 5px;
  margin: 0px;
  font-family: AnimeAce, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
}
.card{
    margin:10px auto;
    padding: 5px;
   
}
.card:hover{
  background-color: wheat;
}
span{
    width: 100%;
    margin: auto 2%;
}
input{
    margin:auto;
}
button{
    margin:auto;
}


</style>
