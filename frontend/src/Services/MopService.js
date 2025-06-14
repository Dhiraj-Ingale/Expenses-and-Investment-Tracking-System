import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class MopService {

    getModeOfPayments() {
        return axios.get(BASE_REST_API_URL + '/modeofpayments');
    }

}

export default new MopService();