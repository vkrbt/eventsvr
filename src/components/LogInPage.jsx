import React from 'react';
import {Form, FormControl, Button} from 'react-bootstrap';
import axios from 'axios';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: null,
      password: null
    };
    this.logIn = this.logIn.bind(this);
    this.successLogIn = this.successLogIn.bind(this);
    this.errorLogIn = this.errorLogIn.bind(this);
  }

  successLogIn(response) {
    localStorage.userData = JSON.stringify({
      token: response.data.Authorization,
      name: response.data.name
    });
    this.props.history.push({pathname: '/search'});
  }

  errorLogIn(error) {
    this.props.history.push({
      pathname: '/info',
      state: {
        button: 'login',
        message: 'Verify that the data entered is correct'
      }
    });
  }

  logIn() {
    axios.post('http://cfd06e2f.ngrok.io/login', {
      "login": this.state.name,
      "password": this.state.password
    })
      .then(this.successLogIn)
      .catch(this.errorLogIn)
  }

  render() {
    return (
      <div className="login-page--container">
        <MainTheme src="/"/>
        <div className="login-page">
          <Form horizontal>
            <FormControl type="text" placeholder="Name" onChange={(e) => this.setState({name: e.target.value})}/>
            <FormControl type="text" placeholder="Password"
                         onChange={(e) => this.setState({password: e.target.value})}/>
          </Form>
          <Button onClick={this.logIn}>LOG IN</Button>
        </div>
      </div>
    )
  }
}

