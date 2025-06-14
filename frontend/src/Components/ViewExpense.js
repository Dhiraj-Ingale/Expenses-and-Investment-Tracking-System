import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Button } from 'reactstrap';
import DatePicker from 'react-date-picker';
import ExpenseService from '../Services/ExpenseServices';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import '../Stylesheets/ViewExpense.css';


function ViewExpense() {
    const [expense, setExpense] = useState({
        expenseId: 0,
        date: new Date(),
        decription: '',
        amount: 0,
        modeOfPayment: { mopId: 1, modeOfPayment: 'Cash'},
        category: {categoryId: 9, categoryName: 'Others', cateoryType: 'Expense'},
        user: {userId: 0, username: ''}
    });
    const [expenses, setExpenses] = useState([]);
    const [user, setUser] = useState(JSON.parse(sessionStorage.getItem('user')));
    const [month, setMonth] = useState();
    const [year, setYear] = useState();
    const navigate = useNavigate();

    useEffect(() => {
        if(localStorage.getItem('user')) {
            setUser(JSON.parse(localStorage.getItem('user')));   
        }
        else {
            setUser(JSON.parse(sessionStorage.getItem('user')));
        }
        console.log(user);
        ExpenseService.getAllExpenses(user).then((res) => {
            setExpenses(res.data);
            console.log(res.data);
        }).catch(error => { 
            console.log(error);
        });
    },[])

    let handleChange = (event) => {
        let date = new Date(event);
        console.log(date.getMonth());
        setMonth(date.getMonth());
        setYear(date.getFullYear());
        console.log((month+1) + ',' + year);
        if(year == null) {
            ExpenseService.getExpensesByMonth(user, (month+1)).then((res) => {
                setExpenses(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else if(month == null) {
            ExpenseService.getExpensesByYear(user, year).then((res) => {
                setExpenses(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else {
            ExpenseService.getExpensesByMonthYear(user, (month+1), year).then((res) => {
                setExpenses(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }     
    }

    let handleDelete = (expenseId) => {
        ExpenseService.deleteExpense(expenseId).then((res) => {
            // setExpenses(...expenses);
            console.log(res);
        }).catch(error => { 
            console.log(error);
        });
    }

    let handleClick = (event) => {
        event.preventDefault();
        navigate('/addexpense');
    }

    let expenselist = 
        expenses.map( expense =>
            <tr className='tablerows' key={expense.expenseId}>
                <td>{expense.date}</td>
                <td>{expense.description}</td>
                <td>{expense.category.categoryName}</td>
                <td>{expense.user.currency.currencySymbol} {expense.amount}</td>
                <td>{expense.modeOfPayment.modeOfPayment}</td>
                <td><Button size='sm' color='danger' onClick={() => handleDelete(expense.expenseId)}>Delete</Button></td>
            </tr>
        );

    return (
        <html>
            <Navigationbar />
            <body style={{
                'height': '82vh',
                'justifyContent': 'center',
                'backgroundColor': '#FFCDD2',
                'overflow': 'auto'
            }}>
                <div style={{ 'height': '50px' }}></div>
                <h1 id='title'>EXPENSE LIST</h1>
                <div id='control'>
                    <div id='month'>
                        <DatePicker maxDetail='year' monthPlaceholder='month' calendarIcon='' onChange={handleChange} />
                    </div>
                    <div id='year'>
                        <DatePicker maxDetail='decade' yearPlaceholder='year' calendarIcon='' onChange={handleChange} />
                    </div>
                    <button id='addbtn' onClick={handleClick}>+ Add Expense</button>
                </div>
                <table id='table'>
                    <thead className='tablehead'>
                        <tr>
                            <th>Date</th>
                            <th>Description</th>
                            <th>Category</th>
                            <th>Amount</th>
                            <th>Mode of Payment</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <br />
                    <tbody className='tablebody'>
                        {expenselist}
                    </tbody>
                </table>

            </body>
            <Footer />
        </html>
    );

}

export default ViewExpense;