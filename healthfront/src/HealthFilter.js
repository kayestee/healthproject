import React, {useEffect, useState} from "react";
import './App.css'
import ListHealth from "./ListHealth";
import {Badge, Card, Col, Jumbotron, Row, Spinner} from "react-bootstrap";
import HealthRecord from "./healthrecord";
import HealthButton from "./HealthButton";
import {Link} from "react-router-dom";


export default function HealthFilter () {
    const [items, setItems] = useState([])
    const [loading, setLoading] = useState(true)
    const [listening, setListening] = useState(false);
    const [status, setStatus] = useState("Ok");

    let eventsource = `http://localhost:8080/healthdata?status=Good`


    useEffect(() => {

        if (!listening) {
            eventsource = new EventSource(`http://localhost:8080/healthdata?status=${status}`);

            eventsource.onopen = e => {
                console.log("Connection opened")
            }

            eventsource.onmessage = e => {
                setItems( items => ([...items, JSON.parse(e.data)]))
                setLoading(false)

            }
            eventsource.onerror = (err) => {
                console.error('EventSource failed:', err);
                eventsource.close();
            }
            setListening(true)
        }

    }, [])

    if (loading) {
        return (
                    <Row className="justify-content-md-center">
                        <Col>
                        <Spinner animation="border" role="status">
                            <span className="sr-only">*</span>
                        </Spinner>
                        </Col>
                    </Row>
        )

    } else {
        return (
            <Row className="justify-content-md-center">
                <Col>
                {
                    items.map((item, index) => (
                        <Card key={item.id}>
                            <Card.Body>
                                <Card.Title>{item.name}
                                </Card.Title>
                                <HealthButton key={item.id} value={item.id} status={item.status}/>
                            </Card.Body>
                        </Card>
                    ))
                }
                </Col>
            </Row>
        )
    }
}
