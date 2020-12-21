<template>
  <div>
      <reading-list/>
      <router-link to="/addBook"> Add Book to Reading List </router-link>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue';
export default {
    components:{
        ReadingList
    }
}
</script>

<style>

</style>