import React from 'react';
import ReactDOM from 'react-dom';
import Course from './Course';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<Course />, div);
  ReactDOM.unmountComponentAtNode(div);
});