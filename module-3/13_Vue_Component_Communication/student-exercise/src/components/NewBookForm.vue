<template>
  <form class = "new-book-form" v-on: submit.prevent="addNewBook">
      <div class = "form-element">
          <label for="title"> Title </label>
          <input class="title-input" id="title" type="text" v-model="newBook.title" />
      </div>
      <div class="form-element">
          <label for="author"> Author:</label>
          <input class="author-input" id="author" type="text" v-model="newBook.author"/>
      </div>
      <div class="form-element">
          <label for="isbn"> Title:</label>
          <input class="isbn-input" id="isbn" type="text" v-model="newBook.isbn" />
      </div>
      <input type="submit" value="Save"/>
    </form>
</template>

<script>
export default {
    name: "new-book",
    data(){
        return {
            newBook: {
                read: false,
            }
        };
    },
    methods: {
        addNewBook(){
            this.$store.commit("ADD_BOOK", this.newBook);
        }
    }
}
</script>

<style>

</style>