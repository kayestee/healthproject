import React, {useState} from "react";
import HealthRecord from "./healthrecord";
import {Accordion} from "react-bootstrap";

export default class ListHealth extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            healthItems : props.healthItems,
        };
    }

    render () {
          const items = this.state.healthItems.items
          return (
              items.map((item) =>
                <HealthRecord id = {item.id} item={item} recordname={ this.state.healthItems.record_name}/>
              ));
        }
}

