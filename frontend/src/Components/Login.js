import React, { useState, useEffect } from 'react';
import { Button, Form, FormGroup } from 'reactstrap';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import LoginService from '../Services/LoginService';
import home from '../Images/home1.png'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';


function Login() {
    const [user, setUser] = useState({});
    // const [user, setUser] = useState({
    //     userId: 0,
    //     username: '',
    //     password: '',
    //     name: '',
    //     email: '',
    //     mobno: '',
    //     currency: {currencyId: 1, currencyName: 'Others', currencySymbol: ''}
    // });
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [remember, setRemember] = useState('false');
    const navigate = useNavigate();

    let handleSubmit = async (e) => {
        e.preventDefault();
        if (username.length === 0) {
            toast.warning('Please enter username');
        } 
        else if (password.length === 0) {
            toast.warning('Please enter password');
        } 
        else {
            // setUser({username: username, password: password});
            await LoginService.validateUser({username: username, password: password}).then(async (res) => {
                console.log(res.data);
                if (res.data === true) {
                    await LoginService.getUser(username).then((res) => {
                        console.log(res.data);
                        setUser(res.data);       
                    }).catch(error => {
                        console.log(error);
                    });
                    console.log(user);                   
                    setTimeout(() => {
                        console.log(user);
                        if (remember === true) {
                            localStorage.setItem('user', JSON.stringify(user));
                            localStorage.setItem('remember', true);
                        }
                        sessionStorage.setItem('user', JSON.stringify(user));
                        navigate('/dashboard');
                    },2000);                   
                }
                else {
                    toast.error('Invalid username or password');
                }
            }).catch(error => {
                console.log(error);
            });
        }
    }

    useEffect(() => {
        
    }, [user]);

    useEffect(() => {
        if(localStorage.getItem('remember')) {
            if(localStorage.getItem('user')) {
                sessionStorage.setItem('user', JSON.stringify(JSON.parse(localStorage.getItem('user'))));
                navigate('/dashboard');
            }
        }
    }, []);

    return (
        <body style={{
            display: 'flex',
            backgroundImage: `url(${home})`,
            backgroundSize: "cover",
            position: "absolute",
            alignItems: 'center',
            width: "100%",
            height: '100%'
        }}>
            <ToastContainer/>
            <h1 style={{
                position: 'absolute',
                marginTop: '-500px',
                marginLeft: '100px',
                color: 'whitesmoke'
            }}>
                Expense & Investment Tracking System
            </h1>
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                position: "absolute",
                width: "500px",
                height: "400px",
                marginLeft: '80px',
                borderRadius: '10px',
                backgroundColor: "rgba(256,256,256,0.3)"
            }}>
                <div className='d-flex m-5 justify-content-center'>
                    <h2>User Login</h2>
                </div>
                <div className='d-flex justify-content-center align-items-center'>
                    <Form onSubmit={handleSubmit}>
                        <FormGroup>
                            <input type='text' style={{width:'300px'}} placeholder='Username' onChange={(e) => setUsername(e.target.value)}/>
                        </FormGroup>
                        <FormGroup>
                            <input type='password' style={{width:'300px'}} placeholder='Password' onChange={(e) => setPassword(e.target.value)}/>
                        </FormGroup>
                        <FormGroup style={{display:'flex', justifyContent:'center', alignItems:'center'}}>
                            <input type='checkbox' onChange={(e) => setRemember(e.target.checked)}/>
                            <span style={{marginLeft:'10px'}}>Remember Me</span>
                        </FormGroup>
                        <FormGroup style={{display:'flex', justifyContent:'center'}}>
                            <Button color='primary' type='submit'>Login</Button>
                        </FormGroup>
                        <FormGroup>
                            Don't have an account?
                            <a href='/register'>Register here</a>
                        </FormGroup>
                    </Form>
                </div>
            </div>
        </body>
    );

}

export default Login;