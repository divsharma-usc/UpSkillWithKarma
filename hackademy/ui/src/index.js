import React from 'react';
import ReactDOM from 'react-dom';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Dashboard from './components/Dashboard/Dashboard'
import CourseInfo from './components/CourseInfo/CourseInfo'
import CourseInfo2 from './components/CourseInfo/CourseInfo2'
import Course from './components/Course/Course'
import './index.css';
import * as serviceWorker from './serviceWorker';
import Profile from './components/Profile/Profile';
import Course2 from './components/Course/Course2'

ReactDOM.render(
  <Router>
    <div className= "App">
      <header className="App-header">
         <img id = "mainLogo" src={process.env.PUBLIC_URL + "/images/hsbc.svg"}></img>
          <h3 id="c2">UpSkill with Karma</h3>
      </header>
      <nav className="breadcrumb-wrapper">
        <ol className="breadcrumb">
          <li className="breadcrumb__item"><a href="/" className="breadcrumb__link">HOME</a></li>
          <li className="breadcrumb__item">ABOUT</li>
          <li className="breadcrumb__item">CONTACT</li>
          <li className="breadcrumb__item">Courses</li>
          <li className="breadcrumb__item"><a href="/profile" className="breadcrumb__link">PROFILE</a></li>
          </ol>
        </nav>
        <Route exact path="/" component={Dashboard} />
      <Route path="/courseInfo" component={CourseInfo} />
      <Route path="/courseInfo2" component={CourseInfo2} />
      <Route path="/course" component={Course} />
      <Route path="/profile" component={Profile} />
      <Route path="/course2" component={Course2} />
      
      
      <div id="footer1">
        <p id="c1">Who are we</p>
        <p id="c1">Our approach</p>
        <p id="c1">Contact</p>
        <p id="c1">Media</p>

      </div>
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
