<template>
  <div class="box">
        <div class="jumbotron jumbotron-fluid shadow">
            <h1>Friends</h1>
            <p> Our newest feature the friend system! A way to stay close to those registered on our site and a way to see the collections of 
                all of your friends regardless of their privacy status for a collection! 
            </p>
        </div>

        <div class="row shadow">
             <h4 class="col-md-12">All Friends</h4>
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
        <div class="row shadow">
            <h4 class="col-md-12">Pending Friends</h4>
             <div class="col-md-2 shadow"> image representing collection
                <p class="row"> collection title </p>
             </div>
        </div>
    </div>
</template>

<script>
export default {
  name: "friends",
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