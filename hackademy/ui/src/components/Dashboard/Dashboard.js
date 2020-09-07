import React from 'react';
import PropTypes from 'prop-types';
import styles from './Dashboard.module.css';

const Dashboard = () => (
  <div className={styles.Dashboard}>
    <img src= {process.env.PUBLIC_URL + "/images/students.jpg"}></img>
    <div><h1>Explore Courses</h1></div>
    <div id = {styles.innerDashboard}>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon6.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon1.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon2.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon3.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon4.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

        <div class = {styles.card}>
          <img  class = {styles.icon} src={process.env.PUBLIC_URL + "/images/icon5.jpg"}></img>
          <div class= {styles.courseHeading}> <h3>Diversity and inclusion </h3></div>
          <div class={styles.courseDetails}> 
            Diversity is in our roots. We believe that diversity brings benefits for our customers, our business and our people
          </div>
          <button class={styles.readMore}>Read More</button>
        </div>

    </div>
  </div>
);

Dashboard.propTypes = {};

Dashboard.defaultProps = {};

export default Dashboard;