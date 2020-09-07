import React from 'react';
import ReactDOM from 'react-dom';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Dashboard from './components/Dashboard/Dashboard'
import CourseInfo from './components/CourseInfo/CourseInfo'
import './index.css';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <Router>
    <div className= "App">
      <header className="App-header">
      </header>
      <Route path="/" component={Dashboard} />
      <Route path="/courseInfo" component={CourseInfo} />
    </div>
  </Router>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
