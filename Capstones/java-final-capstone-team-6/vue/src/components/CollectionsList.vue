<template>
    <span class="row">
        <ul class="col-md-3" v-for="collection in collections" v-bind:key="collection.collectionId">
           <li class="card" v-on:click="toCollection(collection.collectionName, collection.collectionDescription, collection.collectionId)"><!-- --------calls method to push router to collection.vue when card is clicked ------- -->
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{collection.collectionName}}</p>  
            </li>
        </ul>
  </span>
</template>

<script>
import CollectionService from '../services/CollectionService'
export default {
    name: 'collections-list',
    data(){
        return{
            collections:{    
            },
        }
    },
    methods:{
        toCollection(collectionName, collectionDescription, collectionId){
            this.$store.state.collection.collectionName = collectionName;
            this.$store.state.collection.collectionDesc = collectionDescription;
            this.$store.state.collection.collectionId = collectionId;
            this.$router.push(`/collection`)/* routes to collection.vue when called by event */
        }
    },
    created(){
        CollectionService.getCollectionByCurrentUser().then(response => {
            this.collections = response.data
        });
         CollectionService.getAllCollections().then(response => {
          this.collections = response.data
        });
    }
}
</script>

<style scoped>
.card{
    padding:10px;
}
.card:hover{
    background-color: wheat;
}
.card-title{
    padding-top: 10px;
}
.row{
   margin: 10px auto;
}
</style>