import axios from 'axios';

const http = axios.create({
    baseURL: "https://gateway.marvel.com:443/v1/public/"
});

export default {
    getComicIssue(){/* gets a list of 50 comics,*/
        return http.get(`comics?format=comic&formatType=comic&orderBy=title&limit=51&apikey=9d96d996f4bfce42975b47820c47174a&hash=eadb34d00cfcc0a0b08ebf5d5b1123ff&ts=1`);
    },
    getComicsByName(title){
        return http.get(`comics?format=comic&formatType=comic&orderBy=title&limit=50&title=${title}&apikey=9d96d996f4bfce42975b47820c47174a&hash=eadb34d00cfcc0a0b08ebf5d5b1123ff&ts=1`)
    },
    getComicsByCollectionId(collectionId){
        return axios.get(`/collections/${collectionId}`)
    },
    getComicDetails(collectionId, comicId){
        return axios.get(`/collections/${collectionId}/comics/${comicId}`)
    },
    getNonCollectionComicDetails(comicId){
        return http.get(`comics/${comicId}?&apikey=9d96d996f4bfce42975b47820c47174a&hash=eadb34d00cfcc0a0b08ebf5d5b1123ff&ts=1`)
    },
    addNewComic(comic){
        return axios.post(`/comics/`, comic)
    },
    getComicByComicId(comicId){
        return axios.get(`/comics/${comicId}`)
    },
}

