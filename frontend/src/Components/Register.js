import React, { useState,useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import CurrencyService from '../Services/CurrencyService';
import LoginService from '../Services/LoginService';
import background from '../Images/register1.jpeg';

function Register() {
    
    const [user, setUser] = useState({
        name: '',
        username: '',
        password: '',
        email: '',
        mobno: '',
        currency: { currencyId: 1, currencyName: 'Others', currencySymbol: ' '}
    });
    const [currencies, setCurrencies] = useState([]);
    const navigate = useNavigate()

    useEffect(() => {
        CurrencyService.getCurrencies().then((res) => {
            setCurrencies(res.data);
            console.log(res.data);
        }).catch(error => { 
            console.log(error);
        });
    }, [])

    let handleSubmit = async (event) => {
        event.preventDefault();
        await LoginService.saveUser(user).then((res) => {
            setUser(res.data);
        }).catch(error => { 
            console.log(error);
        });
        navigate('/login');
    }

    let handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        let u = {...user};
        u[name] = value;
        setUser(u);
    }

    let handleSelect = (event) => {
        let u = {...user};
        u.currency.currencySymbol = event.target.value;
        currencies.map(c => {
            if(c.currencySymbol === u.currency.currencySymbol) 
                u.currency.currencyId = c.currencyId;
        });
        setUser(u);
    }

    let currencyList = 
        currencies.map(currency => 
            <option key={currency.currencyId}>{currency.currencySymbol}</option>
        );

    return (
        <body style={{
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            position: 'relative',
            backgroundImage: `url(${background})`,
            backgroundSize: "cover",
            height: "100vh"
        }}>
            <div className="d-flex position-absolute" style={{
                width: '30%',
                height: '80vh',
                padding: '10px',
                borderRadius: '10px',
                background: 'rgba(0,0,0,0.6)',
                color: 'white'
            }}>
                <form className="w-100">
                    <h2 className="d-flex justify-content-center text-uppercase"><b>SignUp</b></h2>
                    <br />
                    <div class="col-auto my-0">
                        <input type="text" class="form-control" name="name" placeholder="Name"
                            onChange={handleChange} required />
                    </div>
                    <br />
                    <div class="col-auto">
                        <input type="text" class="form-control" name="username" placeholder="Username"
                            onChange={handleChange} required />
                    </div>
                    <br />
                    <div class="col-auto">
                        <input type="email" class="form-control" name="email" placeholder="Email"
                            onChange={handleChange} required />
                    </div>
                    <br />
                    <div class="col-auto">
                        <input type="text" class="form-control" name="mobno" placeholder="Mobile No."
                            onChange={handleChange} />
                    </div>
                    <br />
                    <div class="col-auto">
                        Currency :
                        <select name="currency" onChange={handleSelect} required>
                            {currencyList}
                        </select>
                    </div>
                    <br />
                    <div class="col-auto">
                        <input type="password" class="form-control" name="password" placeholder="Password"
                            onChange={handleChange} required />
                    </div>
                    <div className="d-flex justify-content-center align-items-center">
                        <button type="submit" className="btn btn-success" onClick={handleSubmit}>Submit</button>

                        <Link to="/login"><button className="m-4 btn btn-dark">Cancel</button></Link>
                    </div>
                </form>
            </div>
        </body>
    );

}

export default Register;