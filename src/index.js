import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import './common/main.css';

import HomePage from './components/HomePage';
import LoginPage from './components/LogInPage';
import SignUpPage from './components/SignUpPage';

ReactDOM.render((
    <BrowserRouter>
        <Switch>
            <Route exact path='/' component={HomePage} />
            <Route path='/login' component={LoginPage} />
            <Route path='/signup' component={SignUpPage} />
        </Switch>
    </BrowserRouter>
), document.getElementById('root'));


