import React, {useEffect, useState} from "react";
import './App.css'
import ListHealth from "./ListHealth";
import {Spinner} from "react-bootstrap";

export default class HealthInfo extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items : [1,2,3],
            fetchError: null,
            loading : true
        };

    }

    componentDidMount(){
        const reqOptions = {
            method: 'GET',
            headers : {'Content-Type': 'application/json'},
        };
        let fetchDomain = `http://${process.env.REACT_APP_HEALTHCHECK_URL}/healthcheck?format=full`;

        fetch(fetchDomain, reqOptions)
            .then(response => response.json())
            .then((result) => {
                    this.setState({items: result, loading: false});
                },
                (error) => {
                    this.setState({fetchError: error, loading:false});
                }
            )
    }

    render() {

        if (this.state.fetchError) {
            return (<div>Error: {this.state.fetchError.message}</div>);
        } else if (this.state.loading) {
            return (<Spinner animation="border" role="status">
                <span className="sr-only">Loading...</span>
            </Spinner>);
        } else {
            return (
                <>
                    <ListHealth healthItems={this.state.items}/>
                </>
            );
        }
    }
}
