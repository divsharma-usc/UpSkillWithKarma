import React from 'react';
import PropTypes from 'prop-types';
import styles from './Course.module.css';
import { useHistory } from 'react-router-dom';

const Course = () => {
const history = useHistory();
const handleClickSubmit = () => {history.push("/course");
  fetch('http://localhost:8080/KC/1/1/CourseCreator1', {
      method: 'PUT'
  }).then(response => console.log(response));
}
return (
  <div className={styles.Course}>
    <img className= {styles.bigImg} src={process.env.PUBLIC_URL + "/images/course.jpg"}></img>
    <div className = {styles.courseTitle}>
      <h2>Diversity and inclusion</h2>
    </div>
    <div className={styles.innerContainer}>
    <div className={styles.courseText}>
      <div>Karma Coins : 100</div>
        <div>Penality : 20</div>
      </div>
      <div className={styles.courseText}>
        <h3>Module 1 | Employee networks</h3>
        <p>
        Our employees lead seven global networks and a variety of HSBC Communities. These voluntary 
        groups bring together employees with shared characteristics and common interests. They aim to make sure 
        everyone feels included, and can help HSBC to address internal challenges and opportunities. Their insight
        into the experience and needs of a diverse customer base can also help our business identify commercial 
        opportunities. Our networks focus on gender, age, ethnicity, LGBT+, faith, working parents and 
        carers, and ability. HSBC Communities have been formed on a range of topics, including flexible 
        working, mindfulness and Chinese culture.
        </p>
        <h3>Module 2 |  Informing an inclusive culture </h3>
        <p>
        Our employees lead seven global networks and a variety of HSBC Communities. These voluntary 
        groups bring together employees with shared characteristics and common interests. They aim to make sure 
        everyone feels included, and can help HSBC to address internal challenges and opportunities. Their insight
        into the experience and needs of a diverse customer base can also help our business identify commercial 
        opportunities. Our networks focus on gender, age, ethnicity, LGBT+, faith, working parents and 
        carers, and ability. HSBC Communities have been formed on a range of topics, including flexible 
        working, mindfulness and Chinese culture.
        </p>
        <h3>Module 3 | Be Open </h3>
        <p>
        Our employees lead seven global networks and a variety of HSBC Communities. These voluntary 
        groups bring together employees with shared characteristics and common interests. They aim to make sure 
        everyone feels included, and can help HSBC to address internal challenges and opportunities. Their insight
        into the experience and needs of a diverse customer base can also help our business identify commercial 
        opportunities. Our networks focus on gender, age, ethnicity, LGBT+, faith, working parents and 
        carers, and ability. HSBC Communities have been formed on a range of topics, including flexible 
        working, mindfulness and Chinese culture.
        </p>
        <h3>Assessment</h3>
        <div>
          Diversity increase the creativity of the team ? <br></br>
          <input type="radio"></input>
          <label for="male">Yes</label>
          <input type="radio"></input>
          <label for="male">No</label>
          <br></br>
          Diversity helps to address gender diversity ? <br></br>
          <input type="radio"></input>
          <label for="male">Yes</label>
          <input type="radio"></input>
          <label for="male">No</label>
        </div>
      </div>
      <div class = {styles.buttonDiv}>
          <button onClick={handleClickSubmit} class={styles.readMore}> | Submit | </button>
          <button class={styles.readMore}> | Leave Course| </button>
      </div>
      </div>
  </div>
);
}
Course.propTypes = {};

Course.defaultProps = {};

export default Course;
