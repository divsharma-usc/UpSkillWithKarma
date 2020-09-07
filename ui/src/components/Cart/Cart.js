import React, { Component } from 'react'

import EmptyCart from './EmptyCart';
import { ProductConsumer} from '../../context';

export default class Store extends Component {
    render() {
        return (
            <section>
                <ProductConsumer>
                    {value => {
                        const { cart } = value;
                        if (cart.length > 0) {
                            return (
                              //  <React.Fragment>
                                //    <Title name="your" title="cart" />
                                 //   <CartColumns />
                                   // <CartList value={value} />
                                   // <CartTotals value={value} history={this.props.history} />
                                //</React.Fragment>
                                <h1>Yash</h1>
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
