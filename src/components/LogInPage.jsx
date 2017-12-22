import React from 'react';
import { Form, FormControl } from 'react-bootstrap';

import MainTheme from './MainTheme';

export default class LoginPage extends React.Component {
  render() {
    return (
      <div className="login-page--container">
        <MainTheme />
        <div className="login-page">
          <Form horizontal>
            <FormControl type="text" placeholder="E-mail" />
            <FormControl type="text" placeholder="Password" />
          </Form>
          <button>LOG IN</button>
        </div>
      </div>
    )
  }
}

