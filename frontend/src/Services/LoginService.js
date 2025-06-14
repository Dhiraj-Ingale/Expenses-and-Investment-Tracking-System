import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class LoginService {

    getUser(username) {
        return axios.get(BASE_REST_API_URL + '/users/u-' + username, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    validateUser(user) {
        console.log(user);
        return axios.post(BASE_REST_API_URL + '/validate-user', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    saveUser(user) {
        return axios.post(BASE_REST_API_URL + '/users', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

}

export default new LoginService();