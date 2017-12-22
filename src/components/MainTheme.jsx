import * as React from 'react';

export default class MainTheme extends React.PureComponent {
  render() {
    const { additionalInfo } = this.props;

    return (
      <div className="main-theme">
        <span>EventsVR</span>
        {additionalInfo ? <p>{additionalInfo}</p> : null}
      </div>
    )
  }
}
