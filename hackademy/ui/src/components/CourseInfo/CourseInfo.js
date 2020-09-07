import React from 'react';
import styles from './CourseInfo.module.css';
import { useHistory } from 'react-router-dom';

const CourseInfo = () => {
  const history = useHistory();

  const handleClickReturn = () => {
      history.push("/");
  }

  const handleClickEnroll = () => {
    history.push("/course");
  }

  return (
  <div className={styles.CourseInfo}>
    <img className= {styles.bigImg} src={process.env.PUBLIC_URL + "/images/diversity.jpg"}></img>
    <div className = {styles.courseTitle}>
      <h2>Diversity and inclusion</h2>
    </div>
    <div className={styles.innerContainer}>
      <div className={styles.courseText}>
        <p>
        As a business operating in markets all around the world, we believe diversity brings benefits 
        for our customers, our business and our people. We want a connected workforce that reflects 
        the communities where we operate and helps us meet the needs of customers from all walks of life. 
        Different ideas and perspectives help us innovate, manage risk, and grow the business in a sustainable 
        way – and difference is celebrated within Our brand.
        </p>
        <p>
        As a business operating in markets all around the world, we believe diversity brings benefits 
        for our customers, our business and our people. We want a connected workforce that reflects 
        the communities where we operate and helps us meet the needs of customers from all walks of life. 
        Different ideas and perspectives help us innovate, manage risk, and grow the business in a sustainable 
        way – and difference is celebrated within Our brand.
        </p>
      </div>
      <div className={styles.courseText}>
        <div>Karma Coins : 100</div>
        <div>Penality : 20</div>
      </div>
      <div class = {styles.buttonDiv}>
          <button onClick={handleClickEnroll} class={styles.readMore}> | Enroll | </button>
          <button onClick={handleClickReturn}  class={styles.readMore}> | Go Back| </button>
      </div>
      </div>
  </div>
);
}

CourseInfo.propTypes = {};

CourseInfo.defaultProps = {};

export default CourseInfo;
