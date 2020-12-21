<template>
  <div class="box">
        <div class="jumbotron jumbotron-fluid shadow">
            <h1>LeaderBoards</h1>
            <p>Track who has the best personal stats throughout the whole site!</p>
        </div>

        <div class="row shadow">
             <h4 class="col-md-12">Leaderboard example 1:</h4>
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
        </div>
    </div>
</template>

<script>
export default {
  name: "leaderboard",
}
</script>

<style scoped>
.box{
  height: 1080px;
}
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
footer {
  text-align:center;
  width: 75%;
  margin:auto;
  padding: 10px;
  background-color:rgba(220, 207, 189, 0.94);
}
</style>