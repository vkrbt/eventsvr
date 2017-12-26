import React from 'react';
import { Form, FormControl, Button } from 'react-bootstrap';
import axios from 'axios';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {
  signUp () {
    axios.post('http://6cb1e3c0.ngrok.io/registration', {
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
      <div className="signup-page--container">
        <MainTheme />
        <div className="signup-page">
          <Form horizontal>
            <FormControl type="text" placeholder="E-mail" />
            <FormControl type="text" placeholder="Username" />
            <FormControl type="text" placeholder="Password" />
            <FormControl type="text" placeholder="Confirm Password" />
          </Form>
          <Button onClick={this.signUp}>SIGN UP</Button>
        </div>
      </div>
    )
  }
}

