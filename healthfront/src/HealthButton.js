import React, {useState} from "react";
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
        this.collapse.current = true;
    }

   render() {
       console.log('tee`');
            return (
                <>
                    <Button className=".btn-flat"
                            onClick={this.doToggle.bind(this)}  id={this.state.id} variant={this.colormap[this.state.status]}>
                        {this.state.status}
                    </Button>

                    <Collapse in={this.state.setOpen}  ref={this.collapse} >
                        <div id="example-collapse-text">
                            You picked item no: {this.state.id}
                        </div>
                    </Collapse>

                </>

            );
        }

}


