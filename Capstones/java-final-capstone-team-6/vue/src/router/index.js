import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Comic from '../views/Comic.vue'
import NewCollection from '../views/NewCollection'
import NewComic from '../views/NewComic'
import store from '../store/index'
import AboutUs from '../views/AboutUs.vue'
import Viewer from '../views/HomeDefault.vue'
import Account from '../views/Account.vue'
import LeaderBoard from '../views/Leaderboard.vue'
import Friends from '../views/Friends.vue'
import Trades from '../views/Trades.vue'
import Collection from '../views/Collection.vue'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/comic",
      name: "comic",
      component: Comic,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/newCollection",
      name: "newCollection",
      component: NewCollection,
      meta: {
        requiresAuth: true
      }
    },
    {
      path:"/newComic",
      name: "newComic",
      component: NewComic,
      meta: {
        requiresAuth: true
      }
    },
    {
      path:"/aboutUs",
      name:"aboutUs",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/",
      name:"viewer",
      component: Viewer,
      meta:{
        requiresAuth: false
      }
    },
    {
    path:"/account",
    name:"account",
    component: Account,
    meta:{
      requiresAuth: true
      }
    },
    {
    path:"/leaderboard",
    name:"leaderboard",
    component: LeaderBoard,
    meta:{
      requiresAuth: false
     }
   },
   {
     path:"/friends",
     name:"friends",
     component: Friends,
     meta:{
       requiresAuth: true
     }
   },
   {
     path:"/trades",
     name:"trades",
     component: Trades,
     meta:{
       requiresAuth: true
     },
   },
   {path:"/collection",
    name: "collection",
    component: Collection,
  meta: {
    requiresAuth: true
  },
}
   
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
