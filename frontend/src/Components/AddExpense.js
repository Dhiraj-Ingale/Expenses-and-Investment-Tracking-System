import React, { useState, useEffect } from 'react';
import { Container, Input, Button, Label, FormGroup, Form } from 'reactstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import DatePicker from 'react-date-picker';
import ExpenseService from '../Services/ExpenseServices';
import CategoryService from '../Services/CategoryService';
import MopService from '../Services/MopService';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import 'react-date-picker/dist/DatePicker.css';

function AddExpense() {

    const [user, setUser] = useState(JSON.parse(sessionStorage.getItem('user')));
    // const [user, setUser] = useState({userId: 2})
    const [expense, setExpense] = useState({
        date: new Date(),
        description: '',
        amount: 0,
        modeOfPayment: { mopId: 1, modeOfPayment: 'Cash'},
        category: {categoryId: 9, categoryName: 'Others', cateoryType: 'Expense'},
        userId: user.userId
    });
    const [categories, setCategories] = useState([]);
    const [mops, setMops] = useState([]);
    const [date, setDate] = useState(new Date());
    const navigate = useNavigate();

    let handleSubmit = (event) => {
        event.preventDefault();
        console.log(expense);
        ExpenseService.saveExpense(expense).then(res => {
            console.log(res.data)
            navigate(('/viewexpense'));
        }).catch(err => {
            console.log(err)
        }); 
    }

    let handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        let exp = {...expense};
        exp[name] = value;
        setExpense(exp);
    }

    let handleSelect = (event) => {
        let exp = {...expense};
        exp.category.categoryName = event.target.value;
        categories.map(e => {
            if(e.category.categoryName === exp.category.categoryName) 
            exp.category.categoryId = e.category.categroyId;
        });
        setExpense(exp);
    }

    let handleMopSelect = (event) => {
        let exp = {...expense};
        exp.modeOfPayment.modeOfPayment = event.target.value;
        mops.map(c => {
            if(c.modeOfPayment === exp.modeOfPayment.modeOfPayment) 
            exp.modeOfPayment.mopId = c.mopId;
        });
        setExpense(exp);
    }

    let handleDateChange = (date) => {
        let exp = {...expense};
        exp.date = date;
        setExpense(exp);
    }

    useEffect(() => {
        if(localStorage.getItem('user')) {
            setUser(JSON.parse(localStorage.getItem('user')));   
        }
        else {
            setUser(JSON.parse(sessionStorage.getItem('user')));
        }
        CategoryService.getCategories('Expense').then((res) => {
            setCategories(res.data);
        }).catch(error => {
            console.log(error);
        });

        MopService.getModeOfPayments().then((res) => {
            setMops(res.data);
        }).catch(error => {
            console.log(error);
        });

    }, []);

    let categoriesList = 
        categories.map( category =>
            <option key={category.categoryId}>{category.categoryName}</option>
        );

    let mopsList = 
        mops.map( mop => 
            <option key={mop.mopId}>{mop.modeOfPayment}</option>
        );

    return (
        <body style={{
            width: '100%',
            height: '100vh',
            alignItems: 'center',
            backgroundColor: 'grey'
        }}>
            <Navigationbar/>
            <h3 style={{ display: "flex", justifyContent: "center" }}>ADD EXPENSE</h3>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <FormGroup className="col-md-5 mb-3" style={{ textAlign: "left", fontWeight: "bold" }}>
                        <Label for='text-left' id="left-label">Description :</Label>
                        <Input style={{ borderBlockColor: "black" }} type="description" name="description" id="description" placeholder="Enter description"
                            onChange={handleChange} />
                    </FormGroup>

                    <hr />

                    <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row" }}>
                        <FormGroup className="col-md-6 mb-3 " style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="category" >Category : </Label>
                            <select onChange={handleSelect} style={{ marginLeft: "10px" }} required>
                                {categoriesList}
                            </select>
                        </FormGroup>

                        <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row", fontWeight: "bold" }}>
                            <Label for="date" style={{ marginRight: "10px" }}>Date:</Label>
                            <DatePicker selected={expense.date} value={expense.date} onChange={handleDateChange}
                                dateFormat="dd/MM/yyyy"
                                showMonthDropdown
                                isClearable
                                dropdownMode="select"
                                className="form-control"
                                placeholderText="Select date"
                                showYearDropdown
                                scrollableMonthYearDropdown required/>
                        </FormGroup>
                    </FormGroup>

                    <hr />

                    <div className="row">
                        <FormGroup className="col-md-3 mb-3" style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="amount">Amount :</Label>
                            <Input style={{ borderBlockColor: "black" }} type="number" name="amount" id="amount" placeholder="Enter ammount"
                                onChange={handleChange} required/>
                        </FormGroup>
                    </div>

                    <div>
                        <FormGroup className="col-md-7 mb-2" style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="Modeofpayment">Mode of Payment :</Label>
                            <select onChange={handleMopSelect} style={{ marginLeft: "10px" }} required>
                                {mopsList}
                            </select>
                        </FormGroup>
                    </div>

                    <hr />

                    <FormGroup>
                        <Button color="primary" type="submit">Save </Button>
                        <Button color="secondary" tag={Link} to="/viewexpense" style={{ marginLeft: "20px" }}>Cancel</Button>
                    </FormGroup>
                    <hr />

                </Form>
            </Container>
            <Footer/>
        </body>
    );
}

export default AddExpense;