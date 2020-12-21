<template>
  <div>
    <div class="jumbotron jumbotron-fluid shadow">
      <h1>Comic League!</h1>
      <p>Track your collection! Share with your friends!</p>
    </div>

    <div class="row shadow">
      <h4 class="col-md-12">My Collections:
        <span> 
            <router-link class="btn btn-dark" v-bind:to="{ name: 'newCollection' }" v-show="$store.state.token != ''">Create New Collection</router-link>
            <router-link class="btn btn-success" v-bind:to="{ name: 'newComic' }" v-show="$store.state.token != ''">Add Comic</router-link>
        </span>
      </h4>
      <div id="mycollection">
        <get-my-collections />
      </div>
    </div>

        <div class="row shadow">
             <h4 class="col-md-12">Featured Collections:</h4>
        <div id="featuredcollection">
          <collections-list />
        </div>
      </div>
    <!-- <div class="row shadow">
      <h4 class="col-md-12">Featured Collections:</h4>
      <div class="col-md-2 shadow">image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
    </div>

    <div class="row shadow">
      <h4 class="col-md-12">Friends Collections:</h4>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
      <div class="col-md-2 shadow"> image representing collection
        <p class="row"> collection title </p>
      </div>
    </div> -->
  </div>
</template>
<script>
import GetMyCollections from '../components/GetMyCollections.vue'
import CollectionService from '../services/CollectionService'
import CollectionsList from '../components/CollectionsList.vue'
export default {
  name: "home",
  components: { GetMyCollections, CollectionsList },
  created(){
    CollectionService.getAllCollections().then(response => {
          this.collections = response.data
        });
  }

};
</script>

<style scoped>

/* --------------------  header ---------------- */
.jumbotron {
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  color: white;
  background-color: rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: auto;
  padding: 20px;
  border: white solid 6px;
  font-kerning: none;
}
/* ------------------------ collection sections ------------- */
div.row {
  background-color:rgba(220, 207, 189, 0.94);
  width: 75%;
  margin: 15px auto;
  padding: 0px;
  border: white solid 6px;
}
.col-md-12 {
  background-color: white;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
  height:50px;
  padding: 10px 0 0 15px;
}
.col-md-12 span{
  position: absolute;
  right: 10px;
  top: 0;
  font-family: Arial, Helvetica, sans-serif;
}
/* ------------------ collection boxes ---------- */
.col-md-2{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
  font-kerning: none;
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
.col-md-12 .btn{
 background-color: none;
 margin: 5px 5px 10px;
 padding: 5px;
}
.btn-dark{
    width: 200px;
    padding: 20px 0;
}
.btn-dark:hover{
  background-color: rgb(80, 80, 76);
}
.btn-success{
    width: 200px;
    padding: 20px 0;
}
</style>
