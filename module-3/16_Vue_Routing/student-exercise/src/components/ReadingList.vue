<template>
  <div class="book-container">
    <book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn" />
    <book-details/>
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';
import BookDetails from './BookDetails.vue';
export default {
    name: 'reading-list',
    components: {
        BookCard,
        BookDetails
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>