<template>
  <div class="box">
    <div class="jumbotron jumbotron-fluid shadow">
            <h1>{{this.$store.state.collection.collectionName}}</h1>
            <h2>{{this.$store.state.collection.collectionDesc}}</h2>
        </div>
      <div class="row shadow">
        <span> <router-link class="btn btn-success"
          v-bind:to="{ name: 'newComic' }">Add Comic</router-link>
        </span>
      </div>
      <div class="row">
          <comics-list />
        </div>
    </div>
</template>

<script>
import ComicsList from '../components/ComicsList.vue';
export default {
  name: "collection",
  components: { ComicsList }
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
 padding: 10px 10px 5px;
 margin: 0px;
 font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
 font-kerning: none;
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
 font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
 font-kerning: none;
}
.col-md-12 .btn{
 margin: auto;
 background-color: none;
 border: none;
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
div h2{
  font-family: AnimeAce;
  font-size: 15px;
}
</style>