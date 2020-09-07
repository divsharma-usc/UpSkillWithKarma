import React from 'react';
import ReactDOM from 'react-dom';
import CourseInfo from './CourseInfo';

it('It should mount', () => {
  const div = document.createElement('div');
  ReactDOM.render(<CourseInfo />, div);
  ReactDOM.unmountComponentAtNode(div);
});