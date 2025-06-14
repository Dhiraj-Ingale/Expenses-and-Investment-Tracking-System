import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class CategoryService {

    getCategories(type) {
        return axios.get(BASE_REST_API_URL + '/categories/' + type);
    }

}

export default new CategoryService();