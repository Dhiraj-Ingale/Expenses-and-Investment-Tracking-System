import { Nav, Navbar, NavItem, NavbarBrand, NavLink, UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { Link, useNavigate } from 'react-router-dom';
import Profilepic from '../Images/Profilepic.jpg';
import 'bootstrap/dist/css/bootstrap.min.css'; 

function Navigationbar() {

    const navigate = useNavigate();

    let handleLogout = (event) => {
        event.preventDefault();
        localStorage.removeItem('user');
        localStorage.removeItem('remember');
        sessionStorage.removeItem('user');
        navigate('/login');
    }

    return (
        <div>
            <Navbar color='dark' expand='md' dark>
                <NavbarBrand href='/dashboard'>Expense Tracker Application</NavbarBrand>
                <Nav className='d-felx ml-auto justify-content-between' navbar>
                    <NavItem>
                        <NavLink href='/dashboard'>Dashboard</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href='/viewincome'>Income</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href='/viewexpense'>Expense</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href='/viewinvestment'>Investment</NavLink>
                    </NavItem>
                    <NavItem>
                        <UncontrolledDropdown>
                            <DropdownToggle caret>
                                    <img src={Profilepic} width="30" height="30" className="rounded-circle"></img>
                            </DropdownToggle>
                            <DropdownMenu>
                                <DropdownItem><a className="dropdown-item" href="/profile">User Profile</a></DropdownItem>
                                <DropdownItem divider />
                                <DropdownItem><a className="dropdown-item" onClick={handleLogout}>Log Out</a></DropdownItem>                                                                   
                            </DropdownMenu>
                        </UncontrolledDropdown>
                    </NavItem>                   
                </Nav>
            </Navbar>
        </div>
    );

}

export default Navigationbar;