import React from 'react';
import axios from 'axios';


export default class TestRequests extends React.Component {

  search() {
    axios.get('http://c2b561cc.ngrok.io/search?streamType=FOOTBALL&page=0&size=19')
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
  autoComplete() {
    axios.get('http://c2b561cc.ngrok.io/autocomplete?name=FOOTBALL&page=0&size=19')
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
  stream() {
    axios.get('http://15823b90.ngrok.io/stream?id=1&frame=1')
      .then(function (response) {
        console.log(response);
        const imgUrl = 'http://15823b90.ngrok.io/'+response.data.url;
        console.log(imgUrl);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
  render() {
    return (
      <div className="test">
        <button className={"test"} onClick={this.autoComplete}>autocomplete</button>
        <button className={"test"} onClick={this.search}>search</button>
        <button className={"test"} onClick={this.stream}>stream</button>
      </div>
    )
  }
}

