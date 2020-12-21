<template>
   <div>
        <div v-for="details in comic.data.results" v-bind:key="details.comicId">
            <div class="col-md shadow" id="comicImageDiv"> 
                <img class="img-fluid float-left mr-2 mx-auto" id="comicImage" v-bind:src="details.thumbnail.path + '.' + details.thumbnail.extension">
                
            </div>
            <div class="col-md">
               <h3 class="text-center mx-auto"> {{details.title}}</h3>
                <h5 class="text-center mx-auto"> {{details.description}}</h5>
                <!-- <h5 class="row text-center"> Characters: {{details.characters.items[0].name}} </h5>  -->
                <!-- Not all of these comics have characters or authors so might have to not use this at all... -->
                <!-- <h5 class="text-center mx-auto"> Author: {{details.creators.items[1].name}} </h5> -->
                <h5 class="text-center mx-auto"> Final-Order-Cutoff Date: {{details.dates[1].date.substring(0,10)}}</h5>
                <h5 class="text-center mx-auto"> Price: ${{details.prices[0].price}} </h5>
            </div>
        </div>
    </div>
</template>

<script>
import ComicServices from '../services/ComicServices.js';
export default {
    name: "comic-detail",
    data() {
        return {
            comic: {
                data:{}
            },
            image: "",
        }
    },
    methods: {
    },
    created(){
        ComicServices.getNonCollectionComicDetails(this.$store.state.comic.comicId).then(response =>{
            this.comic = response.data;
        })        
    }
}
</script>
<style scoped>
.row{
   margin: 10px auto;
}
h5.text-center.mx-auto{
    padding-left: 5px;
    font-family: AnimeAce;
    color: black;
    font-size: 20px;
}
h3.text-center.mx-auto{
    text-decoration: underline;
    font-family: AnimeAce;
}
#comicImage{
    height:auto;
    width:auto;
}
#comicImageDiv{
    
}
</style>
