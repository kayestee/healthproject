import React from "react";
import './App.css'
import ListHealth from "./ListHealth";
import {Badge, Col, Jumbotron, Row, Spinner} from "react-bootstrap";
import {Link} from "react-router-dom";

export default class HealthInfo extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items : {
                "record_name": "Default Records",
                "items": [{
                    "id": 1001,
                    "status": "Good",
                    "name": "Rambo",
                    "sex": "M",
                    "birthdate": "1964-06-02",
                    "contactid": 1
                }]},
            fetchError: null,
            loading : true
        };

    }


    async componentDidMount(){
        const reqOptions = {
            method: 'GET',
            headers : {'Content-Type': 'application/json'},
        };
        let fetchDomainURl = new URL(`http://${process.env.REACT_APP_HEALTHCHECK_URL}/healthcheck?format=full`);
        console.log(fetchDomainURl)

        const response =  fetch(fetchDomainURl, reqOptions)
            .then(response => response.json())
            .then((result) => {
                    this.setState(prevState => {
                        return {
                            ...prevState, items:result,
                            loading:false
                        }
                    });

                },
                (error) => {
                    this.setState(prevState => {
                        return {
                            ...prevState, fetchError:error,
                            loading:false
                        }
                    })
                    return error

                }
            )

    }

    render() {
        return (
        <>
        <Row className="justify-content-md-center">
            <Col>
                <Jumbotron>
                    <h1>Sample Health App</h1>
                    <h6>
                        Updated health information<Badge variant="secondary">Latest</Badge>
                    </h6>
                    <p>
                        <Link variant="primary">Learn more</Link>
                    </p>
                </Jumbotron>

            </Col>
        </Row>
        </>
        )}
}
