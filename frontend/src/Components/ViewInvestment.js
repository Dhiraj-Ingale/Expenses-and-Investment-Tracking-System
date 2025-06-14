import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Button } from 'reactstrap';
import DatePicker from 'react-date-picker';
import InvestmentService from '../Services/InvestmentService';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import '../Stylesheets/ViewExpense.css';

function ViewInvestment() {
    const [investment, setInvestment] = useState({
        investmentId: 0,
        date: new Date(),
        decription: '',
        amount: 0,
        category: {categoryId: 32, categoryName: 'Others', cateoryType: 'Investment'},
        interestRate: 0,
        investmentPeriod: 0,
        user: {userId: 0, username: ''}
    });
    const [investments, setInvestments] = useState([]);
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
        InvestmentService.getAllInvestments(user).then((res) => {
            setInvestments(res.data);
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
            InvestmentService.getInvestmentsByMonth(user, (month+1)).then((res) => {
                setInvestments(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else if(month == null) {
            InvestmentService.getInvestmentsByYear(user, year).then((res) => {
                setInvestments(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }
        else {
            InvestmentService.getInvestmentsByMonthYear(user, (month+1), year).then((res) => {
                setInvestments(res.data);
                console.log(res.data);
            }).catch(error => { 
                console.log(error);
            });
        }     
    }

    let handleDelete = (investmentId) => {
        InvestmentService.deleteInvestment(investmentId).then((res) => {
            // setInvestments(...expenses);
            console.log(res);
        }).catch(error => { 
            console.log(error);
        });
    }

    let handleClick = (event) => {
        event.preventDefault();
        navigate('/addinvestment');
    }

    let investmentlist = 
        investments.map( investment =>
            <tr className='tablerows' key={investment.investmentId}>
                <td>{investment.date}</td>
                <td>{investment.description}</td>
                <td>{investment.category.categoryName}</td>
                <td>{investment.user.currency.currencySymbol} {investment.amount}</td>
                <td>{investment.interestRate}</td>
                <td>{investment.investmentPeriod}</td>
                <td><Button size='sm' color='danger' onClick={() => handleDelete(investment.investmentId)}>Delete</Button></td>
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
                <h1 id='title'>INVESTMENT LIST</h1>
                <div id='control'>
                    <div id='month'>
                        <DatePicker maxDetail='year' monthPlaceholder='month' calendarIcon='' onChange={handleChange} />
                    </div>
                    <div id='year'>
                        <DatePicker maxDetail='decade' yearPlaceholder='year' calendarIcon='' onChange={handleChange} />
                    </div>
                    <button id='addbtn' onClick={handleClick}>+ Add Investment</button>
                </div>
                <table id='table'>
                    <thead className='tablehead'>
                        <tr>
                            <th>Date</th>
                            <th>Description</th>
                            <th>Category</th>
                            <th>Amount</th>
                            <th>Interest Rate (%)</th>
                            <th>Investment Period (years)</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <br />
                    <tbody className='tablebody'>
                        {investmentlist}
                    </tbody>
                </table>

            </body>
            <Footer />
        </html>
    );
}

export default ViewInvestment;