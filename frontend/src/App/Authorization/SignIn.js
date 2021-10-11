import React, {Component} from 'react';
import {Link, withRouter} from 'react-router-dom';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import AppNavbar from '../AppNavbar';

class SignIn extends Component {

    emptyItem = {
        login: '',
        password: '',
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
    }


    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/');
    }

    render() {
        const {item} = this.state;
        const title = <h2>Login</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <div className="row justify-content-center">
                        <div className="col-8">
                            <FormGroup>
                                <Label for="login">Login</Label>
                                <Input type="text" name="login" id="login" value={item.login || ''}
                                       onChange={this.handleChange} autoComplete="login"/>
                            </FormGroup>
                            <FormGroup>
                                <Label for="password">Password</Label>
                                <Input type="text" name="password" id="password" value={item.password || ''}
                                       onChange={this.handleChange} autoComplete="password"/>
                            </FormGroup>
                            <FormGroup>
                                <Button color="primary" type="submit">SignIn</Button>{' '}
                                <Button color="secondary" tag={Link} to="/">Cancel</Button>
                            </FormGroup>
                        </div>
                    </div>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(SignIn);