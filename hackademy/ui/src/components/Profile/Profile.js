import React    from "react";
import template from "./Profile.jsx";
import "bootstrap/dist/css/bootstrap.min.css";

class Profile extends React.Component {
  render() {
    return(
      
    /*<div className='row' style={{ display: "flex", margin: 0 }}>
    <div className='column m-5 pr-5 pl-5 pt-3' styles={{ flex: "33.33%" }}>
        <img src={process.env.PUBLIC_URL + "/images/Person.jpg"} className='figure-img' alt="profile"  />
        <div className="row" style={{ display: "flex", margin: 0, justifyContent: "space-evenly" }}>
                    <div className="col-3" >
                        <img src={process.env.PUBLIC_URL + "/images/Gold.jpg"} className="img-circle" alt="Bronze Karmas" height="100" />
                        <div>1000</div>
                    </div>
                    <div className="col-3">
                        <img src={process.env.PUBLIC_URL + "/images/Silver.jpg"} className="img-circle" alt="Bronze Karmas" height="100"/>

                    </div>
                    <div className="col-3">
                        <img src={process.env.PUBLIC_URL + "/images/Bronze.jpg"} className="img-circle" alt="Bronze Karmas" height="100"/>

                    </div>
                </div>
    </div>
    <div className='container column m-5' style={{ fontSize: "1.5rem", backgroundColor: "lightgray", width: "40%", textAlign: "center", justifyItems: "center" }}>
        <div>Jerry</div>
        <div>Software Engineer</div>
        <div>000000</div>
        <div>Department</div>
    </div>
   

    </div>*/

    <div className="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src={process.env.PUBLIC_URL + "/images/Person.jpg"}alt=""/>
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h3>
                                        Jerry Ghelani
                                    </h3>
                                                                     
                                      <h5>
                                      MSS
                                      </h5>
                                      
                                    <p class="proile-rating">Course Completed : <span>2</span></p>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="/profile" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            {/*<p>WORK LINK</p>
                            <a href="">Website Link</a><br/>
                            <a href="">Bootsnipp Profile</a><br/>
                            <a href="">Bootply Profile</a>
                            <p>SKILLS</p>
                            <a href="">Web Designer</a><br/>
                            <a href="">Web Developer</a><br/>
                            <a href="">WordPress</a><br/>
                            <a href="">WooCommerce</a><br/>
                            <a href="">PHP, .Net</a><br/>*/}
                            <div className="row" style={{ display: "flex", margin: 0, justifyContent: "space-evenly" }}>
                             <div className="col-md-4" >
                        <img src={process.env.PUBLIC_URL + "/images/Gold.jpg"} className="img-circle" alt="Bronze Karmas" height="60" />
                        <div>1000</div>
                    </div>
                    <div className="col-md-4">
                        <img src={process.env.PUBLIC_URL + "/images/Silver.jpg"} className="img-circle" alt="Bronze Karmas" height="60"/>
                          <div>800</div>
                    </div>
                    <div className="col-md-4">
                        <img src={process.env.PUBLIC_URL + "/images/Bronze.jpg"} className="img-circle" alt="Bronze Karmas" height="60"/>
                            <div>200</div>
                    </div>
                    </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>PS Id</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>45063924</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Jerry Ghelani</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>jerryghelani@gmail.com</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>123 456 7890</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Profession</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Software Engineer</p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>

    )}
}

export default Profile;
