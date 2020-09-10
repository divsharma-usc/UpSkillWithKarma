import React from 'react';
import PropTypes from 'prop-types';
import "bootstrap/dist/css/bootstrap.min.css";
import styles from './Course.module.css';
import { useHistory } from 'react-router-dom';
import swal from 'sweetalert';


const Course = () => {
  const history = useHistory();
  const handleClickSubmit = () => {
    swal("Congrats!", "You have completed the course successfully!", "success");
    setTimeout(function () {
      history.push("/");
      fetch('http://localhost:8080/KC/1/1/CourseCreator1', {
        method: 'PUT'
      }).then(response => console.log(response));
    }, 2000)

  }

  const handleClickCancel = () => {
    swal("Are you sure? You will charge Penalty Points", {
      dangerMode: true,
      buttons: true,
    });
    
    setTimeout(function () {
      history.push("/");
      fetch('http://localhost:8080/KC/1/1/CourseCreator1', {
        method: 'PUT'
      }).then(response => console.log(response));
    }, 5000)

  } 


  return (
    <div className={styles.Course}>
      <img className={styles.bigImg} src={process.env.PUBLIC_URL + "/images/diversity.jpg"}></img>
      <div className={styles.courseTitle}>
        <h2>Machine Learning and AI</h2>
      </div>
      <div className={styles.innerContainer}>
        <div className={styles.courseText}>
          <div>Karma Coins : 120</div>
          <div>Penality : 25</div>
        </div>
        <div className={styles.courseText}>
          <h3>Module 1 | What is Artificial Intelligence (AI)?</h3>
          <p>
            Artificial Intelligence is the ability of machines to seemingly think for themselves. AI is demonstrated when a task, formerly performed by a human and thought of as requiring the ability to learn, reason and solve problems, can now be done by a machine. A prime example is an autonomous vehicle. The vehicle is able to perceive its surroundings and make decisions in order to safely reach its destination with no human intervention.
        </p>
          <h3>Module 2 |  Jobs in AI </h3>
          <p>
          Over 3,000 full-time machine learning engineer positions were listed on Indeed.com at the time of this article, with many offering salaries above $125K per year. Data scientist AI jobs typically require a bachelor’s degree or higher in computer science, engineering, or IT and experience with multiple programming languages including Java, C, Python, R, JavaScript and SQL and experience in data science is also a big plus. Top job positions include Artificial Intelligence Engineer, AI Project Manager, Researcher and Artificial Intelligence Consultant and some of the top companies hiring include Amazon, Google, Apple and IBM.
        </p>
          <h3>Module 3 | A Brief History of Artificial Intelligence </h3>
          <p>
          In the present day, we see AI integrated into our everyday lives with personal assistants. AI applications and intelligent machines like Siri, Alexa, Watson, Cortana, LinkedIn, and Google AI Assistant are all popular applications we use to conduct everyday tasks. These assistants can be used to pull information from the web, turn on home appliances, set reminders, talk to each other, and so much more. These types of machine learning and intelligent systems assistants are ever evolving, so the demand for engineers and computer scientists is at an all-time high for this market. Whether you are working on Microsoft Windows, iOS, an open source platform, Google, or Android, you can expect there to be a lot of demand for your skills.
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
        <div class={styles.buttonDiv}>
          {/*<button onClick={handleClickSubmit} class="btn btn-success mr-5">Submit </button>
          <button class="btn btn-danger">Leave Course</button>*/}
          <button onClick={handleClickSubmit} class={styles.readMore}> | Submit | </button>
          <button onClick={handleClickCancel} class={styles.readMore}> | Leave Course| </button>
        </div>
      </div>
    </div>
  );
}
Course.propTypes = {};

Course.defaultProps = {};

export default Course;
