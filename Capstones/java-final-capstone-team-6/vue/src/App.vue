<template>
  <div id="app">
    <div>
      <div class="nav1"></div>
      <ul class="nav nav-tabs">
        <li class="nav-item">   
          <router-link class="nav-link active" 
          v-bind:to="{ name: 'home' }" v-show="$store.state.token != ''">Home</router-link>
        </li>
        <li class="nav-item" >
          <p v-if="$store.state.token != ''"></p>
          <router-link class="nav-link" 
          v-bind:to="{ name: 'viewer' }" v-else>Home</router-link>
        </li>
        <li class="nav-item" >
          <p v-if="$store.state.token != ''"></p>
          <router-link class="nav-link" 
          v-bind:to="{ name: 'login' }" v-else>Login</router-link>
        </li>
        <li class="nav-item" >
          <router-link class="nav-link" 
          v-bind:to="{ name: 'account' }" v-show="$store.state.token != ''">Account</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'friends' }"  v-show="$store.state.token != ''">Friends</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'trades' }"  v-show="$store.state.token != ''">Trades</router-link>
        </li> -->
        <!-- <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'leaderboard' }" >Leaderboards</router-link>
        </li> -->
        <li class="nav-item">
          <router-link class="nav-link"
          v-bind:to="{name: 'aboutUs'}"> About Us </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" 
          v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </li>
      </ul>
    </div>
    <router-view/>
    <footer>
      &copy;  Comic League Enterprises 2020
    </footer>
  </div>
</template>

<style>
 @font-face {
    font-family: CrashLanding;
    src: url("../fonts/crashlanding-bb.italic.ttf");
  }
  @font-face {
    font-family: AnimeAce;
    src: url("../fonts/anime-ace.italic.ttf");
  }
  #app{
    background-image: url("../img/HERO COLLAGE.png");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment:fixed;
    padding-bottom: 10px;
  }
  .nav1{
  border: solid 3px white;
  height: 56px;
  left: 12.5%;
  top: 0;
  position: absolute;
  
  }
  .nav-item {
    background-color:black;
    font-family: CrashLanding;
    font-size: 25px;
    letter-spacing: 2px;
  }
  .nav-link:hover{
    color: rgb(226, 209, 75);
  }
  .nav-link {
    color: white;
  }
  .active.nav-link{
    background-color: lightgrey;
  }
  .nav.nav-tabs{
    width: 75%;
    margin: auto;
    border-bottom: none;
  }
  div h1{
  font-family: CrashLanding;
  font-weight: bold;
  font-size: 75px;
  color: black;
  font-kerning: none;
}
div p{
  font-family: AnimeAce;
  color: black;
}
h2{
  text-align: center;
  color: black;
  font-size:75px;
  font-kerning: none;
}
h3{
  color: black;
  font-kerning: none;
}
footer {
  text-align:center;
  width: 75%;
  margin: auto;
  padding: 10px;
  background-color:rgba(220, 207, 189, 0.94);
  border: solid 6px white;
}
</style>
