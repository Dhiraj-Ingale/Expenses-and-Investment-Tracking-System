import axios from 'axios'; 

const BASE_REST_API_URL = 'http://localhost:8080';

class ExpenseService {
    
    getAllExpenses(user) {
        return axios.post(BASE_REST_API_URL + '/expenses/all', user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getExpensesByMonth(user, month) {
        return axios.post(BASE_REST_API_URL + `/expenses-month/` + month, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getExpensesByYear(user, year) {
        return axios.post(BASE_REST_API_URL + `/expenses-year/` + year, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    getExpensesByMonthYear(user, month, year) {
        return axios.post(BASE_REST_API_URL + `/expenses/` + month + `/` + year, user, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    saveExpense(expense) {
        return axios.post(BASE_REST_API_URL + `/expenses`, expense, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    deleteExpense(expenseId) {
        return axios.delete(BASE_REST_API_URL + `/expenses/${expenseId}`, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

}

export default new ExpenseService();