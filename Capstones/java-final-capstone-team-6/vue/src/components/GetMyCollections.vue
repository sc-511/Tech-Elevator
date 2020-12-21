<template>
    <span class="row">
        <ul class="col-md-3" v-for="collection in collections.slice(0,4)" v-bind:key="collection.collectionId">
           <li class="card" v-on:click="toCollection(collection.collectionName)"><!-- --------calls method to push router to collection.vue when card is clicked ------- -->
                <img class="card-img-top" src="http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg">
                <p class="card-title">{{collection.collectionName}}</p>
            </li>
        </ul>
        <span class="contain"> 
            <router-link class="btn btn-info" v-bind:to="{ name: 'account' }">View More</router-link> 
        </span>
  </span>
</template>

<script>
import CollectionService from '../services/CollectionService'
export default {
    name: 'get-my-collections',
    data(){
        return{
            collections:{    
            },
        }
    },
    methods:{
        toCollection(collectionName){
            this.$store.state.collection.collectionName = collectionName;
            this.$router.push(`/collection`)/* routes to collection.vue when called by event */
        }
    },
    created(){
        CollectionService.getCollectionByCurrentUser().then(response => {
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
.contain {
    width: 100%;
    margin:0 15px 5px;
   text-align: center;
   
}
.btn-dark{
    width: 100%;
    padding: 20px 0;
}
.btn-dark:hover{
  background-color: rgb(80, 80, 76);
}
.btn-success{
    width: 100%;
    margin: 20px auto;
    padding: 20px 0;
}
.btn.btn-info{
   display:flex;
   justify-content: center;
   align-items: center;
   margin: 0 auto;
   margin-left: auto;
   margin-right: auto;
   
}
</style>