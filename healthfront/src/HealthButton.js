import React from "react";
import Button from 'react-bootstrap/Button';
import {Collapse} from "react-bootstrap";


export default class HealthButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            setOpen : false,
            open: false,
            id: props.id,
            status : props.status,
        };
        this.collapse = React.createRef();
        this.colormap = {'Good': 'success', 'Ok' :'warning','Bad': 'danger'};
    }

    doToggle(){
        this.open = !this.open;
        this.setState({setOpen : this.open});
    }

   render() {
       console.log('tee`');
            return (
                <>
                    <Button className=".btn-flat"
                            onClick={this.doToggle.bind(this)}  id={this.state.id} variant={this.colormap[this.state.status]}>
                        {this.state.status}
                    </Button>

                </>

            );
        }

}


