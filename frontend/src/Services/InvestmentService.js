import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class IncomeService {
    
    getAllInvestments(user) {
        return axios.post(BASE_REST_API_URL + '/investments/all', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getInvestmentsByMonth(user, month) {
        return axios.post(BASE_REST_API_URL + `/investments-month/${month}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getInvestmentsByYear(user, year) {
        return axios.post(BASE_REST_API_URL + `/investments-year/${year}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getInvestmentsByMonthYear(user, month, year) {
        return axios.post(BASE_REST_API_URL + `/investments/${month}/${year}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    saveInvestment(investment) {
        return axios.post(BASE_REST_API_URL + `/investments`, investment, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    deleteInvestment(investmentId) {
        return axios.delete(BASE_REST_API_URL + `/investments/${investmentId}`, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

}

export default new IncomeService();