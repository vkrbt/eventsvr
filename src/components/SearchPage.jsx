import * as React from 'react';
import { Navbar, FormGroup, FormControl } from 'react-bootstrap';

import PaginationComponent from './PaginationComponent';

export default class SearchPage extends React.Component {
  onKeyDown = (e) => {
    // const query = e.target.value;
  }
  render() {
    const userName = 'katya';
    return (
      <div className="search-page--container">
        <div className="search-page--navbar">
          <Navbar inverse navbar-fixed-top="true">
            <Navbar.Header>
              <Navbar.Brand>
                Hello, {userName}
              </Navbar.Brand>
            </Navbar.Header>
            <FormGroup>
              <FormControl type="text" placeholder="Search" onKeyDown={this.onKeyDown} />
            </FormGroup>
          </Navbar>
        </div>
        <div className="search-page--results"></div>
        <PaginationComponent items={19} />
      </div>
    );
  }
}
