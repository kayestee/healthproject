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

    //
    // componentDidMount (){
    //     const reqOptions = {
    //         method: 'GET',
    //         headers : {'Content-Type': 'application/json'},
    //     };
    //     let fetchDomain = `http://${process.env.REACT_APP_HEALTHCHECK_URL}/patientinfo/`;
    //
    //     fetch(fetchDomain, reqOptions)
    //         .then(response => response.json())
    //         .then((result) => {
    //                 this.setState({items: result, loading: false});
    //             },
    //             (error) => {
    //                 this.setState({fetchError: error, loading:false});
    //             }
    //         )
    // }


    render () {
          const items = this.state.healthItems.items
          return (
              items.map((item) =>
                <HealthRecord id = {item.id} item={item} recordname={ this.state.healthItems.record_name}/>
              ));
        }
}

