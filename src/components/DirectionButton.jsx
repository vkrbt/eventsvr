import * as React from 'react';
import { Link } from 'react-router-dom';

export default class DirectionButton extends React.Component {
  render() {
    return (
      <Link to={this.props.src} className="direction-button"/>
    )
  }
}
