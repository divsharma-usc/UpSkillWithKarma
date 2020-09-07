import React, { Component } from 'react'
import EmptyCart from './EmptyCart';
import {ButtonContainer} from './../Button';
import { ProductConsumer} from '../../context';
import axios from 'axios';
import { Link } from 'react-router-dom';


export default class Course extends Component {

    async componentDidMount() {
        const url = "http://localhost:8080/KarmaWallet/1/Emp1/1";
        const response = await fetch(url);
        const data = await response.json();
       console.log("hey yash"+data);
    }


    linking = () => {
         window.location.href = "/";

        //console.log("Sharvi")
        //console.log(window.location.href = "/")
        
      }





    //   fetchData = () => {
        
    //     const url = "http://localhost:8080/KarmaWallet/2/Emp1/2";
        
    //     axios.get(url)
    //         .then(response => {
    //             this.setState({
    //                 data: response.data,
    //             });
    //         })
    //         console.log(this.state.data)
    // }

    handleClick(){
        const url = "http://localhost:8080/KarmaWallet/2/Emp1/2";
        axios.get(url)
            .then(response => {
                this.setState({
                    data: response.data,
                });
            })
            //console.log(this.state.data)
           // window.location.href = "/";
    }

    render() {
        return (
            <section>
                <ProductConsumer>
                    {value => {
                        const { cart } = value;
                        if (cart.length > 0) {
                            return (
<div>
                                <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                                <img src="/img/product-1.png" className="img-fluid" alt="product" />
                                </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                                 <h3>Module-1</h3><p>Getting started</p>
                               </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                              <h3>Module-2</h3><p>Python Basics</p>
                               </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                               <h3>Module-3</h3><p>Working with Files</p>
                               </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                              <h3>Module-4</h3><p>Working with Web data</p>
                               </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                            <h3>Module-5</h3><p>Working with date and time</p>
                               </div>
                               <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                               <Link to="/">
                               <ButtonContainer onClick={this.handleClick}>
                                   Complete the Course
                                   </ButtonContainer>
                                   </Link>
                                   </div>
</div>
                              //  <React.Fragment>
                                //    <Title name="your" title="cart" />
                                 //   <CartColumns />
                                   // <CartList value={value} />
                                   // <CartTotals value={value} history={this.props.history} />
                                //</React.Fragment>
                              
                            );
                        } else {
                            return <EmptyCart />;
                        }
                    }}
                </ProductConsumer>
            </section>
        );
    }
}
