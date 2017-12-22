import React from 'react';
import { Form, FormControl, Button } from 'react-bootstrap';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {
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
          <Button>SIGN UP</Button>
        </div>
      </div>
    )
  }
}

