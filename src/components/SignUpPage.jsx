import React from 'react';
import {Form, FormControl, Button} from 'react-bootstrap';
import axios from 'axios';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: null,
      password: null,
      email: null
    };
    this.signUp = this.signUp.bind(this);
    this.successRegistration = this.successRegistration.bind(this);
    this.errorRegistration = this.errorRegistration.bind(this);
  }

  successRegistration(response) {
    this.props.history.push({
      pathname: '/info',
      state: {
        button: 'login',
        message: 'Your registration was successful! Please log in'
      }
    });
  }

  errorRegistration(error) {
    this.props.history.push({
      pathname: '/info',
      state: {
        button: 'signup',
        message: 'This user is already exists. Try to register again'
      }
    });
  }

  signUp() {
    axios.post('http://cfd06e2f.ngrok.io/registration', {
      "login": this.state.name,
      "e-mail": this.state.email,
      "password": this.state.password
    })
      .then(this.successRegistration)
      .catch(this.errorRegistration);
  }

  render() {
    return (
      <div className="signup-page--container">
        <MainTheme src="/"/>
        <div className="signup-page">
          <Form horizontal>
            <FormControl type="text" placeholder="E-mail" onChange={(e) => this.setState({email: e.target.value})}/>
            <FormControl type="text" placeholder="Username" onChange={(e) => this.setState({name: e.target.value})}/>
            <FormControl type="text" placeholder="Password"
                         onChange={(e) => this.setState({password: e.target.value})}/>
          </Form>
          <Button onClick={this.signUp}>SIGN UP</Button>
        </div>
      </div>
    )
  }
}

