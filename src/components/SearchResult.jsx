import * as React from 'react';
import { Panel } from 'react-bootstrap';

export default class SearchResult extends React.Component {
  render() {
    const { name, imgUrl, viewersCount, streamer, description } = this.props;
    return (
      <Panel header={name} key={streamer} className="search-result--container">
        <img className="search-result--img" src={imgUrl} alt='search-result-img' />
        <div className="search-result--info">
          <p>{description}</p>
          <span className="search-result--counter">
            <span className="glyphicon glyphicon-eye-open"></span>
            {viewersCount}
          </span>
        </div>
      </Panel>
    )
  }
}
