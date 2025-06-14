import React, { useState, useEffect } from 'react';
import { Container, Input, Button, Label, FormGroup, Form } from 'reactstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import DatePicker from 'react-date-picker';
import IncomeService from '../Services/IncomeService';
import CategoryService from '../Services/CategoryService';
import Navigationbar from '../Components/Navigationbar';
import Footer from '../Components/Footer';
import 'react-date-picker/dist/DatePicker.css';

function AddIncome() {
    const user = JSON.parse(sessionStorage.getItem('user'));
    // const [user, setUser] = useState({userId: 2})
    const [income, setIncome] = useState({
        date: new Date(),
        amount: 0,
        category: {categoryId: 1, categoryName: 'Others', cateoryType: 'Income'},
        userId: user.userId
    });
    const [categories, setCategories] = useState([]);
    const [date, setDate] = useState(new Date());
    const navigate = useNavigate();

    let handleSubmit = (event) => {
        event.preventDefault();
        IncomeService.saveIncome(income).then(res => {
            console.log(res.data)
            navigate(('/viewincome'));
        }).catch(err => {
            console.log(err)
        }); 
    }

    let handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        let inc = {...income};
        inc[name] = value;
        setIncome(inc);
    }

    let handleSelect = (event) => {
        let inc = {...income};
        inc.category.categoryName = event.target.value;
        categories.map(e => {
            if(e.category.categoryName === inc.category.categoryName) 
            inc.category.categoryId = e.category.categroyId;
        });
        setIncome(inc);
    }

    let handleDateChange = (date) => {
        let inc = {...income};
        inc.date = date;
        setIncome(inc);
    }

    useEffect(() => {
        CategoryService.getCategories('Income').then((res) => {
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
            height: '100vh',
            alignItems: 'center',
            backgroundColor: 'grey'
        }}>
            <Navigationbar/>
            <h3 style={{ display: "flex", justifyContent: "center", marginBottom: "20px" }}>ADD INCOME</h3>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row"}}>
                        <FormGroup className="col-md-6 mb-3 " style={{ textAlign: "left", fontWeight: "bold" }}>
                            <Label for="category" >Category : </Label>
                            <select onChange={handleSelect} style={{ marginLeft: "10px" }} required>
                                {categoriesList}
                            </select>
                        </FormGroup>

                        <FormGroup style={{ textAlign: "left", display: "flex", flexDirection: "row", fontWeight: "bold" }}>
                            <Label for="date" style={{ marginRight: "10px" }}>Date:</Label>
                            <DatePicker selected={income.date} value={income.date} onChange={handleDateChange}
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

                    <hr />

                    <FormGroup>
                        <Button color="primary" type="submit">Save </Button>
                        <Button color="secondary" tag={Link} to="/viewincome" style={{ marginLeft: "20px" }}>Cancel</Button>
                    </FormGroup>
                    <hr />

                </Form>
            </Container> 
            <Footer/>                    
        </body>
    );
}

export default AddIncome;