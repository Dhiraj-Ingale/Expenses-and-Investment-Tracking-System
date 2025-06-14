import  React,{ useState, useEffect } from 'react';
import {Link} from 'react-router-dom'
import Navigationbar from "../Components/Navigationbar";
import Footer from '../Components/Footer';
import background from "../Images/Living.jpeg";
import 'bootstrap/dist/css/bootstrap.min.css';
import DashboardService from '../Services/DashboardService';

function DashBoard() {
    const [user, setUser] = useState(JSON.parse(sessionStorage.getItem('user')));
    const [sumOfIncome, setSumOfIncome] = useState(0);
    const [sumOfExpense, setSumOfExpense] = useState(0);
    const [sumOfInvestment, setSumOfInvestment] = useState(0);
    const [incomePieData, setIncomePieData] = useState([[]]);
    const [expensePieData, setExpensePieData] = useState([[]]);
    const [investmentPieData, setInvestmentPieData] = useState([[]]);
    const [incomeLineData, setIncomeLineData] = useState([[]]);
    const [expenseLineData, setExpenseLineData] = useState([[]]);
    const [year, setYear] = useState();

    useEffect(() => {
        if(localStorage.getItem('user')) {
            setUser(JSON.parse(localStorage.getItem('user')));   
        }
        else {
            setUser(JSON.parse(sessionStorage.getItem('user')));
        }
        console.log(user);
        DashboardService.getSumofExpenses(user).then((res) => {
            setSumOfExpense(res.data);
            console.log(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getSumofIncomes(user).then((res) => {
            setSumOfIncome(res.data);
            console.log(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getSumofInvestments(user).then((res) => {
            setSumOfInvestment(res.data);
            console.log(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getExpensePieChart(user).then((res) => {
            setExpensePieData(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getIncomePieChart(user).then((res) => {
            setIncomePieData(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getInvestmentPieChart(user).then((res) => {
            setInvestmentPieData(res.data);
        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getExpenseLineChart(user, year).then((res) => {

        }).catch(error => { 
            console.log(error);
        });

        DashboardService.getIncomeLineChart(user, year).then((res) => {

        }).catch(error => { 
            console.log(error);
        });

    },[])

    return (
        <html style={{
            background: background,
        }}>
            <Navigationbar />
            <body style={{
                height: '80vh',
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center'
            }}>
                <div className='d-flex justify-content-center m-3' style={{
                    width: '60%',
                    background: 'rgba(0,0,0,0.3)',
                    borderRadius: '10px'
                }}>
                    <div className="d-flex align-items-center card m-3" style={{padding:'10px', borderRadius:'10px'}}>
                        <h3>Total Income : </h3>
                        <h1>{sumOfIncome}</h1>
                    </div>
                    <div className="d-flex align-items-center card m-3" style={{padding:'10px', borderRadius:'10px'}}>
                        <h3>Total Expenses : </h3>
                        <h1>{sumOfExpense}</h1>
                    </div>
                    <div className="d-flex align-items-center card m-3" style={{padding:'10px', borderRadius:'10px'}}>
                        <h3>Total Investment : </h3>
                        <h1>{sumOfInvestment}</h1>
                    </div>
                </div>
            </body>
            <Footer/>
        </html>        
    );

}

export default DashBoard;