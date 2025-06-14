import React, { useState, useEffect } from 'react';
import { Container, Input, Button, Label, FormGroup, Form } from 'reactstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import DatePicker from 'react-date-picker';
import InvestmentService from '../Services/InvestmentService';
import CategoryService from '../Services/CategoryService';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import 'react-date-picker/dist/DatePicker.css';

function AddInvestment() {
    const user = JSON.parse(sessionStorage.getItem('user'));
    // const [user, setUser] = useState({userId: 2})
    const [investment, setInvestment] = useState({
        description: '',
        date: new Date(),
        amount: 0,
        category: {categoryId: 32, categoryName: 'Others', cateoryType: 'Investment'},
        interestRate: 0,
        investmentPeriod: 0,
        userId: user.userId
    });
    const [categories, setCategories] = useState([]);
    const [date, setDate] = useState(new Date());
    const navigate = useNavigate();

    let handleSubmit = (event) => {
        event.preventDefault();
        InvestmentService.saveInvestment(investment).then(res => {
            console.log(res.data)
            navigate(('/viewinvestment'));
        }).catch(err => {
            console.log(err)
        }); 
    }

    let handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        let inv = {...investment};
        inv[name] = value;
        setInvestment(inv);
    }

    let handleSelect = (event) => {
        let inv = {...investment};
        inv.category.categoryName = event.target.value;
        categories.map(e => {
            if(e.category.categoryName === inv.category.categoryName) 
            inv.category.categoryId = e.category.categroyId;
        });
        setInvestment(inv);
    }

    let handleDateChange = (date) => {
        let inv = {...investment};
        inv.date = date;
        setInvestment(inv);
    }

    useEffect(() => {
        CategoryService.getCategories('Investment').then((res) => {
            setCategories(res.data);
        }).catch(error => {
            console.log(error);
        });
    }, []);

    let categoriesList = 
        categories.map( category =>
            <option key={category.categoryId}>{category.categoryName}</option>
        );

    return (
        <body style={{
            width: '100%',
            alignItems: 'center',
            backgroundColor: 'grey'
        }}>
            <Navigationbar/>
            <h3 style={{ display: "flex", justifyContent: "center" }}>ADD INVESTMENT</h3>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <FormGroup className="col-md-5 mb-3" style={{ textAlign: "left", fontWeight: "bold" }}>
                        <Label for='text-left' id="left-label">Description :</Label>
                        <Input style={{ borderBlockColor: "black" }} type="description" name="description" id="description" placeholder="Enter description"
                            onChange={handleChange} />
                    </FormGroup>
                    <hr/>
                    <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row" }}>
                        <FormGroup className="col-md-6 mb-3 " style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="category" >Category : </Label>
                            <select onChange={handleSelect} style={{ marginLeft: "10px" }} required>
                                {categoriesList}
                            </select>
                        </FormGroup>

                        <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row", fontWeight: "bold" }}>
                            <Label for="date" style={{ marginRight: "10px" }}>Date:</Label>
                            <DatePicker selected={investment.date} value={investment.date} onChange={handleDateChange}
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
                            <Input style={{ borderBlockColor: "black" }} type="number" name="amount" id="amount" placeholder="Enter amount"
                                onChange={handleChange} required/>
                        </FormGroup>
                    </div>

                    <hr />

                    <div className="row">
                        <FormGroup className="col-md-2 mb-3" style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="interestRate">Investment Rate :</Label>
                            <Input style={{ borderBlockColor: "black" }} type="number" name="interestRate" placeholder="Enter Interest Rates"
                                onChange={handleChange} required/>
                        </FormGroup>
                    </div>

                    <div className="row">
                        <FormGroup className="col-md-2 mb-3" style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="investmentPeriod">Investment Period :</Label>
                            <Input style={{ borderBlockColor: "black" }} type="number" name="investmentPeriod" placeholder="Enter Investment Period"
                                onChange={handleChange} required/>
                        </FormGroup>
                    </div>

                    <hr/>

                    <FormGroup>
                        <Button color="primary" type="submit">Save </Button>
                        <Button color="secondary" tag={Link} to="/viewinvestment" style={{ marginLeft: "20px" }}>Cancel</Button>
                    </FormGroup>
                    <br/>
                    <br/>
                </Form>
            </Container>
            <Footer/>
        </body>
    );
}

export default AddInvestment;