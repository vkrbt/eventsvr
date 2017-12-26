import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';

import './common/main.css';

import HomePage from './components/HomePage';
import LoginPage from './components/LogInPage';
import SignUpPage from './components/SignUpPage';
import VirtualPage from "./components/VirtualPage";
import SearchPage from './components/SearchPage';
import InfoPage from "./components/InfoPage";

ReactDOM.render((
  <BrowserRouter>
    <Switch>
      <Route exact path='/' component={HomePage}/>
      <Route path='/login' component={LoginPage}/>
      <Route path='/signup' component={SignUpPage}/>
      <Route path='/signup' component={SignUpPage}/>
      <Route path='/virtual' component={VirtualPage}/>
      <Route path='/search' component={SearchPage}/>
      <Route path='/info' component={InfoPage}/>
    </Switch>
  </BrowserRouter>
), document.getElementById('root'));


