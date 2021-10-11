import React, {Component} from 'react';
import './App/App.css';
import AppNavbar from './App/AppNavbar';
import {Link} from 'react-router-dom';
import {Container} from 'reactstrap';
import logo from './resources/spidey.png'

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="row">
                        <div className="col-md-3">
                            <img className="img-fluid rounded" src={logo} alt="Img error"/>
                        </div>
                        <div className="col-md-9">
                            <h1 className="display-4">Hi, dear guest!</h1>
                            <p className="lead">You're on the marketplace, where you can buy/sell some collectable stuff</p>
                            <div>

                                <div className="alert alert-warning">
                                    <span>Need to </span>
                                    <Link className="alert-link" to="/login">authorize</Link>
                                </div>
                                <div className="alert alert-warning">
                                    <span>Don't have account?</span>&nbsp;
                                    <Link className="alert-link" to="/register">Register now</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </Container>
            </div>
        );
    }
}
export default Home;