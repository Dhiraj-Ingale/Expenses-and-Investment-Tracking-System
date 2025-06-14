import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class IncomeService {
    
    getAllIncomes(user) {
        return axios.post(BASE_REST_API_URL + '/incomes/all', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getIncomesByMonth(user, month) {
        return axios.post(BASE_REST_API_URL + `/incomes-month/${month}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getIncomesByYear(user, year) {
        return axios.post(BASE_REST_API_URL + `/incomes-year/${year}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getIncomesByMonthYear(user, month, year) {
        return axios.post(BASE_REST_API_URL + `/incomes/${month}/${year}`, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    saveIncome(income) {
        return axios.post(BASE_REST_API_URL + `/incomes`, income, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    deleteIncome(incomeId) {
        return axios.delete(BASE_REST_API_URL + `/incomes/${incomeId}`, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

}

export default new IncomeService();