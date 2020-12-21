<template>
    <div>
        <div class="row">
            <div class="col-md-8">
                <input type="text" v-model="collection.collectionName" class="form-control" placeholder="Collection Title" name="Collection Title">
            </div>
            <div class="col-md-2">
                <button type="button" v-show="visibility" v-on:click="changeVis()" class="btn btn-primary">Make Private</button>
                <button type="button" v-show="!visibility" v-on:click="changeVis()" class="btn btn-primary">Make Public</button>
            </div>
            <div class="col-md-2">
                <button type="button" v-show="!fav" v-on:click="changeFav()" class="btn btn-primary">Make Favorite</button>
                <button type="button" v-show="fav" v-on:click="changeFav()" class="btn btn-primary">Unfavorite</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <textarea v-model="collection.collectionDescription" class="form-control" rows="5" placeholder="Collection Description"/>
            </div>
            <div class="col">
                <button class="btn-primary" v-on:click="saveCollectionAndAddComics(collection)">Save and Add Comics</button>
                <button class="btn-primary" v-on:click="saveCollectionAndReturnToAccount(collection)">Save and Return to Account</button>
            </div>
        </div>
    </div>
</template>

<script>

import CollectionService from "../services/CollectionService.js"

export default {
    name: "add-collection",
    data() {
        return {
            
            fav: false,
            visibility: false,
            collection: {
                collectionId: "",
                userId:"",
                collectionName: "",
                collectionDescription: "",
                favoriteStatusId: 2,
                collectionVisibilityId: 1,
            }
        };
    },
    methods: {
        saveCollectionAndAddComics(collection) {
            CollectionService.createCollection(collection).then(response =>{
                if(response.status === 201){
                    this.$router.push(`/newComic`)
                }
            });
        },
        saveCollectionAndReturnToAccount(collection) {
            CollectionService.createCollection(collection).then(response => {
                if(response.status === 201){
                    this.$router.push(`/account`)
                }
            });
        },
        changeVis(){
            if(this.collection.collectionVisibilityId == 1){
                this.collection.collectionVisibilityId = 2;
                this.visibility = !this.visibility;
            }else if(this.collection.collectionVisibilityId == 2){
                this.collection.collectionVisibilityId = 1;
                this.visibility = !this.visibility;
            }
        } ,
        changeFav(){
            if(this.collection.favoriteStatusId == 1){
                this.collection.favoriteStatusId = 2;
                this.fav = !this.fav;
            }else if(this.collection.favoriteStatusId == 2){
                this.collection.favoriteStatusId = 1;
                this.fav = !this.fav;
            }
        } 
    },
    
}

</script>

<style scoped>
    div{
        width: 100%;
        margin: 5px 0;
    }
    .btn{
        width: 100%;
    }
    .btn-primary{
        width: 100%;
        margin: 5px;
    }
</style>