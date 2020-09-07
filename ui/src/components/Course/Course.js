import React, { Component } from 'react'
import EmptyCart from './EmptyCart';
import {ButtonContainer} from './../Button';
import { ProductConsumer} from '../../context';

export default class Course extends Component {
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
                               <ButtonContainer>
                                   Complete the Course
                                   </ButtonContainer>
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
