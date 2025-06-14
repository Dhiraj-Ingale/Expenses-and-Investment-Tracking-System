import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class DashboardService {

    getSumofExpenses(user) {
        return axios.post(BASE_REST_API_URL + '/expenses/sum', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getSumofIncomes(user) {
        return axios.post(BASE_REST_API_URL + '/incomes/sum', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getSumofInvestments(user) {
        return axios.post(BASE_REST_API_URL + '/investments/sum', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getExpensePieChart(user) {
        return axios.post(BASE_REST_API_URL + '/expenses/pie-graph', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getIncomePieChart(user) {
        return axios.post(BASE_REST_API_URL + '/incomes/pie-graph', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getInvestmentPieChart(user) {
        return axios.post(BASE_REST_API_URL + '/investments/pie-graph', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getExpenseLineChart(user, year) {
        return axios.post(BASE_REST_API_URL + '/expenses/line-graph/' + year, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getIncomeLineChart(user, year) {
        return axios.post(BASE_REST_API_URL + '/incomes/line-graph/' + year, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
    }

}

export default new DashboardService();