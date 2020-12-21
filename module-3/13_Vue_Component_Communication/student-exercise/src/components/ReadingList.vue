<template>
  <div class="book-container">
    <book-card v-for="mybook in $store.state.books" v-bind:key ="mybook.title" v-bind:book="mybook"> 

    </book-card>

  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
  components: { BookCard },
    name: 'reading-list'
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>