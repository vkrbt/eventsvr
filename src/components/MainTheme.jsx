import * as React from 'react';
import DirectionButton from "./DirectionButton";

export default class MainTheme extends React.Component {
  render() {
    const additionalInfo = this.props.additionalInfo;
    const src = this.props.src;

    return (
      <div className="main-theme">
        {src ? <DirectionButton src={src}/> : null}
        <span>EventsVR</span>
        {additionalInfo ? <p>{additionalInfo}</p> : null}
      </div>
    )
  }
}
