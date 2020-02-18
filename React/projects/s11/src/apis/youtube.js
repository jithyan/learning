import axios from 'axios';

const KEY = 'AIzaSyDrQk6TmkCXqgJGf7V4kwyFyzknOyN81mw';

export default axios.create({
    baseURL: 'https://www.googleapis.com/youtube/v3',
    params: {
        part: 'snippet',
        maxResults: 5,
        key: KEY
    }
});