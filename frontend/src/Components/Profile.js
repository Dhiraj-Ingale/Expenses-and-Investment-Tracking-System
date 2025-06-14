import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom'
import { Button, FormGroup } from 'reactstrap';
import Navigationbar from './Navigationbar';
import LoginService from '../Services/LoginService';
import Profilepic from "../Images/Profilepic.jpg";
import 'bootstrap/dist/css/bootstrap.min.css';


const Profile = () => {
    let [user, setUser] = useState(JSON.parse(sessionStorage.getItem('user')));
    const navigate = useNavigate();

    useEffect(() => {
        LoginService.getUser(user.username).then((res) => {
            setUser(res.data);
            console.log(res.data);
        }).catch(error => {
            console.log(error);
        });
    }, []);


    let handleLogout = (event) => {
        event.preventDefault();
        localStorage.removeItem('user');
        localStorage.removeItem('remember');
        sessionStorage.removeItem('user');
        navigate('/login');
    }

    return (
        <>
            <Navigationbar/>
            <div className="container fluid mt-3 " style={{ color: "white", background: "#610c61", height: "550px", width: "600px", boxShadow: "0px 10px 20px -10px rgba(0,0,0,0.65)" }}>
                <form method="">
                    <div className="row-5">
                        <div className="d-flex justify-content-center align-items-center col">
                            <div className="profile-img mt-2  ">
                                <img src={Profilepic} className="rounded-circle" style={{ height: "150px", width: "150px", paddingTop: "10px" }} alt="Cinque Terre" />
                            </div>
                        </div>

                        <div className="col mt-2">
                            <div className="profile-head ">
                                <ul className="nav nav-tabs" style={{ fontSize: "16px", fontWeight: "bold" }} id="myTab" role="tablist">
                                    <li className="nav-item">
                                        <a className="nav-link active" style={{ background: "#b19eee", color: "black" }} id="User-tab" data-toggle="tab" href="#profile" role="tab" >User Details</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col  about-info mt-4">
                            <div className="tab-content profile-tab" id="myTabContent">
                                <div className="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <div className="row">
                                        <div className="col">
                                            <label>USER NAME</label>
                                        </div>
                                        <div className="col">
                                            <p>{user.username}</p>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col">
                                            <label>NAME</label>
                                        </div>
                                        <div className="col">
                                            <p>{user.name}</p>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col">
                                            <label>EMAIL</label>
                                        </div>
                                        <div className="col">
                                            <p>{user.email}</p>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col">
                                            <label>PHONE NUMBER</label>
                                        </div>
                                        <div className="col">
                                            <p>{user.mobno}</p>
                                        </div>
                                    </div>

                                    <div className="row">
                                        <div className="col">
                                            <label>CURRENCY</label>
                                        </div>
                                        <div className="col">
                                            {/* <p>{user.currency.currencySymbol} {user.currency.currencyName}</p> */}
                                        </div>
                                    </div>
                                </div>
                                <div className='d-flex justify-content-center align-items-center col mt-4'>
                                    <FormGroup>
                                        <Button color="danger" onClick={handleLogout}>Logout</Button>
                                        <Button color="secondary" style={{ marginLeft: "20px" }} tag={Link} to="/dashboard">Cancel</Button>
                                    </FormGroup>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </>
    )
}
export default Profile;