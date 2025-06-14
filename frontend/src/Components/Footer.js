import { Link } from 'react-router-dom';
// import 'bootstrap/dist/css/bootstrap.min.css';

function Footer() {

    return (
        <footer class="bg-light text-center text-lg-start fixed-bottom">
            <section class="d-flex justify-content-center justify-content-lg-between p-0.5 border-bottom">
                <div class="me-3 d-none d-lg-block">
                    <span>Get connected with us on social networks:</span>
                </div>
                <div>
                    <a href="" class="me-3 text-reset">
                        <i class="fab fa-linkedin"></i>
                    </a>
                    <a href="" class="me-3 text-reset">
                        <i class="fab fa-github"></i>
                    </a>
                </div>
            </section>
            <div class="text-center p-0.5" style={{"background-color": "rgba(0, 0, 0, 0.2)"}}>
                © 2022 Copyright, All rights reserved :
                <a class="text-dark">Project Group 6</a>
            </div>
        </footer>
    );

}

export default Footer;