import React, {useState} from "react";
import Button from 'react-bootstrap/Button';
import {Accordion, Card} from "react-bootstrap";
import HealthButton from "./HealthButton";


export default class HealthDisplay extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            item: props.item
        };
    }

    render() {
        return (
        <>
                <Card>
                    <Card.Body>
                    <Card.Title>
                        {this.state.item.id}
                    </Card.Title>
                    <Card.Text>
                        {this.state.item.status}
                        </Card.Text>
                        <HealthButton value={this.state.item.id} status={this.state.item.status} />

                    </Card.Body>

                </Card>




        </>
        );
    }
}


