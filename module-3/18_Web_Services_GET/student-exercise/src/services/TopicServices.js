import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });
  
  export default {
  
    getTopics() {
      return http.get('/topics');
    },
  
     getTopicsByID(topicsID) {
       return http.get(`/topics/${topicsID}`)
     },
  
    // getTopicsByID(topicsID) {
    //   return http.get(`/topics/${topicsID}`).then((response) => {
    //     const topics = response.data.id;
    //     return topics.find(topic => topic.id == topicsID);
    //   })
    // }
  
  }