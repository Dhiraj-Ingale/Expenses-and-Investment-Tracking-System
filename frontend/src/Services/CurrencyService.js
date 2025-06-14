import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class CurrencyService {

    getCurrencies() {
        return axios.get(BASE_REST_API_URL + '/currencies');
    }

}

export default new CurrencyService();