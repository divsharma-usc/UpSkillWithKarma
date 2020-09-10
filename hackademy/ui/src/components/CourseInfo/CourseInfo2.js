import React from 'react';
import styles from './CourseInfo.module.css';
import { useHistory } from 'react-router-dom';

const CourseInfo = () => {
  const history = useHistory();

  const handleClickReturn = () => {
      history.push("/");
  }

  const handleClickEnroll = () => {
    history.push("/course2");
    fetch('http://localhost:8080/KarmaWallet/1/Emp1/1', {
        method: 'PUT'
    }).then(response => console.log(response));
  }

  return (
  <div className={styles.CourseInfo}>
    <img className= {styles.bigImg} src={process.env.PUBLIC_URL + "/images/CourseInfo2.jpg"}></img>
    <div className = {styles.courseTitle}>
      <h2>Diversity and inclusion</h2>
    </div>
    <div className={styles.innerContainer}>
      <div className={styles.courseText}>
        <p>
        Artificial intelligence is a technology which enables a machine to simulate human behavior. Machine learning is a subset of AI which allows a machine to automatically learn from past data without programming explicitly. The goal of AI is to make a smart computer system like humans to solve complex problems.
        </p>
        <p>
        Artificial intelligence is a technology which enables a machine to simulate human behavior. Machine learning is a subset of AI which allows a machine to automatically learn from past data without programming explicitly. The goal of AI is to make a smart computer system like humans to solve complex problems.
        </p>
      </div>
      <div className={styles.courseText}>
        <div>Karma Coins : 120</div>
        <div>Penality : 25</div>
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
