<template>
<span> 
    <div class="form-group" >
        <label for="sel1">Select collection to add comic to:</label>
        <select class="form-control">
            <option v-for="collection in collections" v-bind:key="collection.collectionId" v-on:click="setColId(collection.collectionId)">{{collection.collectionName}}</option>
        </select>
    </div> 
        
    <div class="row">
        <input v-model="comicTitle" type="search" class="form-control col-md-9" placeholder="Search Comics by Issue Name..." name="q">
        <button class="btn btn-dark col-md-2" v-on:click="searchComics(comicTitle)">Search</button>
    </div>

    <div class="row">
        <ul class="col-md-4" v-for="comic in comics.data.results.slice(0,comicsToShow)" v-bind:key="comic.title">
            <li class="card">
                <img class="card-img-top" v-bind:src="comic.thumbnail.path + '.' + comic.thumbnail.extension">
                <p class="card-title">{{comic.title}}</p>
    
                Comic Condition
                <select id="tag" class="form-control" v-model="condition">
                    <option value="1" v-on:click="setCondition(condition)">Mint</option>
                    <option value="2" v-on:click="setCondition(condition)">Fair</option>
                    <option value="3" v-on:click="setCondition(condition)">Poor</option>
                </select>
   
                <div class="btn btn-success" v-on:click="trader()" v-if="trade != ''">Mark Tradable?</div>
                <div class="btn btn-danger" v-on:click="trader()" v-else >Mark Untradable</div>
                <div class="btn btn-dark" v-on:click="setAndSend(comic)">Add to Collection</div>
            </li>
        </ul>
        <button class="btn btn-success col-md-2 btn-lg" id="viewComicsButton" v-on:click="showMore()" v-if="!readMore"> View More </button>
        <button class="btn btn-success col-md-2 btn-lg" id="viewComicsButton" v-on:click="showLess()" v-if="readMore"> View Less </button>
    </div>
</span>
</template>

<script>
import CollectionService from '@/services/CollectionService.js'
import ComicServices from "@/services/ComicServices.js"
import AccountServices from "@/services/AccountServices.js"

export default {
    name: "add-comic",
    data(){
        return{
            currentAccount: {},
            condition: '',
            trade: 1,
            comicTitle: '',
            collections:{
            },
            comics: {
                data:{
                    results:[]
                }
            },
            account:{
                userId:'',
                comicId:'',
                collectionId:'',    /*collection id comic condition and trade status all selected by user */
                comicConditionId: '',
                comicTradableStatusId: 1,
                accountTypeId: 2
            },
            comic:{
                comicId:'',
                comicName:'',
                comicCharacters:'',
                authorName:'',
                datePublished:''
            },
            comicsToShow: 12,
            readMore: false,
        }
    },
    methods: {
        setCondition(valueSet){
            this.account.comicConditionId = valueSet;
        },
        setColId(id){
            this.account.collectionId = id;
        },
        trader(){
            if(this.trade == ''){
                this.account.comicTradableStatusId = 2;
                this.trade = 1;
            }else if(this.trade == 1){
                this.account.comicTradableStatusId = 1
                this.trade = '';
            }
        },
        searchComics(title) {
            ComicServices.getComicsByName(title).then(response => {
                this.comics = response.data;
                this.comicTitle = '';
            })
        },
        setAndSend(comic){
            this.account.userId = this.currentAccount.userId;
            this.comic.comicId = comic.id;
            this.comic.comicName = comic.title;
            this.comic.comicCharacters = comic.characters.items[0].name;
            this.comic.authorName = comic.creators.items[0].name;
            this.comic.datePublished = comic.dates[0].date;
            this.account.comicId = comic.id;
            ComicServices.addNewComic(this.comic);
            AccountServices.addComicToAccount(this.account);
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
    created(){
        CollectionService.getCollectionByCurrentUser().then(response => {
            this.collections = response.data;
            });
            AccountServices.getAccount().then(response => {
                this.currentAccount = response.data;
            });
        }
}
</script>

<style scoped>
.dropdown{
    margin:50px;
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
.card{
    margin:10px auto;
    padding: 5px;
}
ul{
   list-style-type: none; 
}
#viewComicsButton{
    margin-top: 10px;
}
    


</style>