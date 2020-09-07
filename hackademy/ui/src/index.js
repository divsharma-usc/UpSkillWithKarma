import React from 'react';
import ReactDOM from 'react-dom';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Dashboard from './components/Dashboard/Dashboard'
import CourseInfo from './components/CourseInfo/CourseInfo'
import Course from './components/Course/Course'
import './index.css';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <Router>
    <div className= "App">
      <header className="App-header">
         <img id = "mainLogo" src={process.env.PUBLIC_URL + "/images/hsbc.svg"}></img>
          <h2>UpSkill with Karma</h2>
      </header>
      <Route exact path="/" component={Dashboard} />
      <Route path="/courseInfo" component={CourseInfo} />
      <Route path="/course" component={Course} />
      <div id="footer1"></div>
      <div id="footer2">
      <p>Terms and conditions</p>
      <p>Privacy notice</p>
      <p>Cookie notice</p>
      <p>Accessibility</p>
      <p>Online security</p>
      <p>Sitemap</p>
      </div>
    </div>
  </Router>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
