import * as React from 'react';
import MainTheme from './MainTheme';
import {Link} from 'react-router-dom';

export default class InfoPage extends React.Component {
  render() {
    const button = this.props.location.state.button === 'login' ? <Link to='/login'>
      <button>LOG IN</button>
    </Link> : <Link to='/signup'>
      <button>SIGN UP</button>
    </Link>;
    return (
      <div className="info-page--container">
        <MainTheme additionalInfo={this.props.location.state.message}/>
        <div className="info-page--buttons">
          {button}
        </div>
      </div>
    )
  }
}
