import React from 'react';
import MainTheme from './MainTheme';
import { Link } from 'react-router-dom';

export default class HomePage extends React.Component {
  render() {
    const additionalInfo = `EventsVR's live streaming platform is \
      a white label platform that allows broadcasters to \
      stream interactive VR content with a VR headset.`

    return (
      <div className="home-page--container">
        <MainTheme additionalInfo={additionalInfo} />
        <div className="home-page--buttons">
          <Link to='/signup'><button>SIGN UP</button></Link>
          <Link to='/login'><button>LOG IN</button></Link>
        </div>
      </div>
    )
  }
}

