import React, {useEffect, useState} from "react";
import './App.css'
import LoginScreen from "./LoginScreen";
import {Spinner} from "react-bootstrap";

export default class HealthLogin extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading : true,
        };

    }


    render() {

        if (this.state.fetchError) {
            return (<div>Error: {this.state.fetchError.message}</div>);
        } else if (this.state.loading) {
            return (<Spinner animation="border" role="status">
                <span className="sr-only">...</span>
            </Spinner>);
        } else {
            return (
                <>
                    <LoginScreen/>
                </>
            );
        }
    }
}
