import * as React from 'react';
import axios from 'axios';
import { Navbar, FormGroup, FormControl, Checkbox } from 'react-bootstrap';

// import PaginationComponent from './PaginationComponent';
import SearchResult from './SearchResult';

export default class SearchPage extends React.Component {
  constructor(props) {
    super(props);

    const initialResults = [{
      name: 'Real Madrid vs Barcelona',
      thumbnail: 'https://goo.gl/z8VXmc',
      description: 'La Liga champions Real Madrid are set to take on arch rivals FC Barcelona in the Spanish Primera Liga game ...',
      viewersCount: 120452,
    },
    {
      name: 'Floyd Mayweather vs. Conor McGregor',
      thumbnail: 'https://goo.gl/mEfDta',
      description: 'Floyd Mayweather Jr. vs. Conor McGregor, also known as "The Money Fight" and "The Biggest Fight in Combat Sports History ...',
      viewersCount: 181589,
    },
    {
      name: 'Bucks vs. Cavaliers',
      thumbnail: 'https://goo.gl/8zKG61',
      description: ' The final minutes of the Bucks and Cavaliers game was wild, as we saw Cleveland march back from a 16-point deficit to ...',
      viewersCount: 302554,
    }];

    const initialTitle = 'Most popular streams';
    this.defaultState = { results: initialResults, title: initialTitle };
    this.state = this.defaultState;
  }

  onKeyDown = (e) => {
    const query = e.target.value;
    if (query) {
      axios.get(`http://10c24089.ngrok.io/search?&name=${query}&page=0&size=10`,
        {headers: {'Authorization': JSON.parse(localStorage.userData).token}})
        .then((response) => {
          this.saveResults(response.data.content, `Results for '${query}'`);
        })
        .catch((error) => {
          console.log(error);
        });
    } else this.setDefaultState(this.defaultState);
  }

  saveResults = (data, str) => {
    this.setState({
      results: [...data],
      title: data.length ? str : 'There are no results that match your search :c',
    });
  }

  setDefaultState = (state) => {
    this.setState(state);
  }

  onClick = (e) => {
    let streamType = e.target.name;
    const title = e.target.name === 'FOOTBALL' ? 'Top footballs streams' : 'Top basketball streams';

    if (e.target.checked && streamType !== 'ALL') {
      axios.get(`http://10c24089.ngrok.io/filter?streamType=${streamType}&page=0&size=19`,
        {headers: {'Authorization': JSON.parse(localStorage.userData).token}})
        .then((response) => {
          this.saveResults(response.data.content, title)
        })
        .catch((error) => {
          console.log(error);
        });
    } else this.setDefaultState(this.defaultState);
  }

  render() {
    const userName = localStorage.userData ? JSON.parse(localStorage.userData).name : '';
    const results = this.state.results ? this.state.results.map((res) => {
      return (
        <SearchResult
          name={res.name}
          imgUrl={res.thumbnail}
          streamer={res.streamer}
          viewersCount={res.viewersCount}
          description={res.description}
        />);
    }) : null;

    return (
      <div className="search-page--container">
        <div className="search-page--navbar">
          <Navbar inverse fixedTop>
            <Navbar.Header>
              <Navbar.Brand>
                Hello, {userName}
              </Navbar.Brand>
            </Navbar.Header>
            <FormGroup>
              <FormControl type="text" placeholder="Search" onBlur={this.onBlur} />
            </FormGroup>
            <FormGroup>
              <Checkbox className="filter" defaultChecked inline name="ALL" onClick={this.onChange}>All</Checkbox>
              {' '}
              <Checkbox className="filter" inline name="FOOTBALL" onClick={this.onClick}>Football</Checkbox>
              {' '}
              <Checkbox className="filter" inline name="BASKETBALL" onClick={this.onClick}>Basketball</Checkbox>
            </FormGroup>
          </Navbar>
        </div>
        <div className="search-page--results">
          <h3>{this.state.title}</h3>
          {results}
        </div>
        {/*<PaginationComponent items={19} />*/}
      </div>
    );
  }
}
