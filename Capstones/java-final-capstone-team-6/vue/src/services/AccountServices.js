import axios from 'axios';

export default {
    addComicToAccount(account){
       return axios.post(`/account/`, account)
    },
    getAccountsByCollectionId(collectionId){
        return axios.get(`/account/collections/${collectionId}/comics`)
    },
    getComicByAccountId(accountId){
        return axios.get(`/account/comics/${accountId}`)
    },
    getAccount(){
        return axios.get(`/account`)
    }
}