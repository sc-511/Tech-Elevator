<template>
    <div class="box">
        <div class="jumbotron jumbotron-fluid">
            <h2>Add Comics</h2>
        </div>
        <div class="row">
            <add-comic />
        </div>
    </div>
</template>

<script>
import AddComic from '../components/AddComic.vue'
export default {
    name: 'NewComic',
  components: { AddComic },

}
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
.box{
    background-attachment: local;
    padding-bottom: 5px;
}
.jumbotron{
    width: 75%;
    margin: auto;
    padding: 30px 15px;
    border: white solid 6px;
}
.row{
    width: 75%;
    margin: 10px auto;
    padding: 15px 5px 15px 5px;
    background-color: rgba(220, 207, 189, 0.94);
    border: white solid 6px;
}
</style>