import * as React from 'react';
import { Pagination } from 'react-bootstrap';

export default class PaginationComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activePage: this.props.activePage || 1,
    }
  }

  getInitialState = () => {
    return {
      activePage: 1,
    };
  }

  handleSelect = (eventKey) => {
    this.setState({
      activePage: eventKey,
    });
  }

  render() {
    const { items } = this.props;
    return (
      <Pagination className="search-page--pagination"
        bsSize="small"
        items={items}
        prev
        next
        maxButtons={5}
        activePage={this.state.activePage}
        onSelect={this.handleSelect}
      />
    );
  }
}
