import React from 'react';
import { Form, FormControl } from 'react-bootstrap';
import axios from 'axios';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {

  logIn() {
    axios.post('http://6cb1e3c0.ngrok.io/login', {
      "login": "katya",
      "password": "123"
    })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
  render() {
    return (
      <div className="login-page--container">
        <MainTheme />
        <div className="login-page">
          <Form horizontal>
            <FormControl type="text" placeholder="E-mail" />
            <FormControl type="text" placeholder="Password" />
          </Form>
          <button onClick={this.logIn}>LOG IN</button>
        </div>
      </div>
    )
  }
}

