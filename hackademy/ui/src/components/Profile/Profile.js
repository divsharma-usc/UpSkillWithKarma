import React    from "react";
import template from "./Profile.jsx";
import "bootstrap/dist/css/bootstrap.min.css";

class Profile extends React.Component {
  render() {
    return(
      
    <div className='row' style={{ display: "flex", margin: 0 }}>
    <div className='column m-5 pr-5 pl-5 pt-3' styles={{ flex: "33.33%" }}>
        <img src={process.env.PUBLIC_URL + "/images/Person.jpg"} className='figure-img' alt="profile" style={{height:"100%",width:"150%"}} />
    </div>
    <div className='container column m-5' style={{ fontSize: "1.5rem", backgroundColor: "lightgray", width: "40%", textAlign: "center", justifyItems: "center" }}>
        <div>Jerry</div>
        <div>Software Engineer</div>
        <div>000000</div>
        <div>Department</div>
    </div>
    <div className="row" style={{ display: "flex", margin: 0, justifyContent: "space-evenly" }}>
                    <div className="col-4" >
                        <img src={process.env.PUBLIC_URL + "/images/Gold.jpg"} className="figure-img karmas" alt="Bronze Karmas" style={{ height: "4cm", width: "4cm" }} />
                        <div>1000</div>
                    </div>
                    <div className="col-4">
                        <img src={process.env.PUBLIC_URL + "/images/Silver.jpg"} className="figure-img karmas" alt="Bronze Karmas" style={{ height: "4cm", width: "4cm" }}/>

                    </div>
                    <div className="col-4">
                        <img src={process.env.PUBLIC_URL + "/images/Bronze.jpg"} className="figure-img karmas" alt="Bronze Karmas" style={{ height: "4cm", width: "4cm" }}/>

                    </div>
                </div>

</div>

    )}
}

export default Profile;
