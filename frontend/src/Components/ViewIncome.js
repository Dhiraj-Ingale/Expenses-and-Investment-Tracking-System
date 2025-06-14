import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Button } from 'reactstrap';
import DatePicker from 'react-date-picker';
import IncomeService from '../Services/IncomeService';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import '../Stylesheets/ViewExpense.css';

function ViewIncome() {
    const [income, setIncome] = useState({
        incomeId: 0,
        date: new Date(),
        amount: 0,
        category: {categoryId: 1, categoryName: 'Others', cateoryType: 'Income'},
        user: {userId: 0, username: ''}
    });
    const [incomes, setIncomes] = useState([]);
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
        IncomeService.getAllIncomes(user).then((res) => {
            setIncomes(res.data);
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
            IncomeService.getIncomesByMonth(user, (month+1)).then((res) => {
                setIncomes(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else if(month == null) {
            IncomeService.getIncomesByYear(user, year).then((res) => {
                setIncomes(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else {
            IncomeService.getIncomesByMonthYear(user, (month+1), year).then((res) => {
                setIncomes(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }     
    }

    let handleDelete = (incomeId) => {
        IncomeService.deleteIncome(incomeId).then((res) => {
            // setIncomes(...incomes);
            console.log(res);
        }).catch(error => { 
            console.log(error);
        });
    }

    let handleClick = (event) => {
        event.preventDefault();
        navigate('/addincome');
    }

    let incomelist = 
        incomes.map( income =>
            <tr className='tablerows' key={income.incomeId}>
                <td>{income.date}</td>
                <td>{income.category.categoryName}</td>
                <td>{income.user.currency.currencySymbol} {income.amount}</td>
                <td><Button size='sm' color='danger' onClick={() => handleDelete(income.incomeId)}>Delete</Button></td>
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
                <h1 id='title'>INCOME LIST</h1>
                <div id='control'>
                    <div id='month'>
                        <DatePicker maxDetail='year' monthPlaceholder='month' calendarIcon='' onChange={handleChange} />
                    </div>
                    <div id='year'>
                        <DatePicker maxDetail='decade' yearPlaceholder='year' calendarIcon='' onChange={handleChange} />
                    </div>
                    <button id='addbtn' onClick={handleClick}>+ Add Income</button>
                </div>
                <table id='table'>
                    <thead className='tablehead'>
                        <tr>
                            <th>Date</th>
                            <th>Category</th>
                            <th>Amount</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <br />
                    <tbody className='tablebody'>
                        {incomelist}
                    </tbody>
                </table>

            </body>
            <Footer />
        </html>
    );

}

export default ViewIncome;