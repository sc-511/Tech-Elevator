<template>
    <div id="collectionPage">
        <span class="row shadow">
            <ul class="col-md-4" v-for="account in accounts" v-bind:key="account.accountId">
                <li class="card"  v-on:click="toComicDetails(comics.comicId)">
                    <img class="card-img-top" id="comicImage" v-bind:src="details.thumbnail.path + '.' + details.thumbnail.extension">
                </li>
            </ul>
    </span>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
import AccountServices from '../services/AccountServices';
import ComicServices from '../services/ComicServices';
export default {
    name: 'comics-list',
    data(){
        return{
            collectionName: '',
            collectionDesc: '',
            collection: {},
            comicName: '',
            accounts: {           
            },
            comics: {
            },
            collections: {
            }
        }
    },
    methods: {
        toComicDetails(comicId){ 
            ComicServices.getNonCollectionComicDetails(comicId).then(response => {
                this.$store.state.accounts.comicId = response.data.comicId;
            })
            this.$router.push(`/comic/`)
        },
        // retrieveAccounts(collectionId) {
        //     AccountServices
        //     .getAccountsByCollectionId(this.collectionId)
        //     .then(response => {
        //         this.$store.state.accounts.collectionId = response.data.collectionId;
        //         this.$store.state.accounts.comicId = response.data.comicId;
        //         this.$store.commit("SET_ACCOUNTS", response.data.accounts);
        //     })
        //     .catch(error => {
        //         if (error.response && error.response.status === 404) {
        //             alert(
        //                 "Comics not available. This collection may have been deleted or you have entered an invalid collection ID."
        //             );
        //             this.$router.push("/");
        //         }
        //     })
        // },
        retrieveComics(comicId) {
            ComicServices
            .getComicByComicId(comicId)
            .then(response => {
                this.comicName = response.data.comicName;
                this.$store.commit("SET_COMICS", response.data.comics);
            })
        }
    },
    created() {
        AccountServices.getAccountsByCollectionId(this.$store.state.collection.collectionId).then(response => {
            this.accounts = response.data
        })
        CollectionService.getCollectionByCurrentUser().then(response => {
            this.collections = response.data
        })
        ComicServices.getComicByComicId(this.$store.state.comic.comicId).then(response => {
            this.comics = response.data;
        })
    }
};
</script>
<style scoped>
.card-title{
    padding-top: 10px;
}
.row{
   margin: 10px auto;
}
.card{
    margin:10px auto;
    padding: 5px;
}
.card:hover{
  background-color: wheat;
}
span{
    width: 100%;
    margin: auto 2%;
}
</style>