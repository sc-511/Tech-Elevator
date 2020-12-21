<template>
<div>
  <div class="jumbotron jumbotron-fluid">
        <h2>Create New Collection</h2>
  </div>
  <div class="row">
        <add-collection />
  </div>
</div>
</template>

<script>
import AddCollection from '../components/AddCollection.vue'
export default {
    name: 'NewCollection',
  components: { AddCollection },

}
</script>

<style scoped>

 h2{
   font-family: CrashLanding;
 }
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
.row{
    width: 75%;
    margin: 10px auto;
    padding: 15px 5px 15px 5px;
    background-color: rgba(138, 138, 138, 0.94);
    border: white solid 6px;
}
</style>