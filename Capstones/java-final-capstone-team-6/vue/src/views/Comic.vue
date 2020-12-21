<template>
<div>
  <div class="jumbotron jumbotron-fluid shadow">
      <h1>Comic book</h1>
  </div>
  <div class="row shadow">
       <comic-details />
    </div>
</div>

  
</template>

<script>
import ComicDetails from '../components/ComicDetails.vue'
export default {
  components: { ComicDetails },

}
</script>

<style scoped>

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
.col-md{
  margin: 20px auto;
  padding: 0px;
  background-color: white; /*replace with image that represents collection */
  border: darkgrey solid 1px;
  text-align: center;
  font-family: AnimeAce;
  font-kerning: none;
}
div h5 {
  width: 100%;
  height: 200px;
  display: block;
  border-top: darkgrey solid 1px;
  padding: 5px;
  text-align: left;
  margin: 0px;
  font-family: CrashLanding, Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-kerning: none;
}
/* ------------- footer ------------ */
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color:rgba(220, 207, 189, 0.94);
}

/* --------------- for buttons on a smaller screen -------------- */
@media only screen and (max-width: 800px) {
  .contain{
    width: 75%;
    margin:auto auto 20px;
  }  
}

</style>