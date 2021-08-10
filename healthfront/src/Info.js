import React from "react";
import './App.css'

export default class Info extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: {
                "record_name": "Default Records",
                "items": [{
                    "id": 1001,
                    "status": "Good",
                    "name": "Rambo",
                    "sex": "M",
                    "birthdate": "1964-06-02",
                    "contactid": 1
                }],
            }
        };
    }

    render() {
        return (
            <div>
                <p>Just saying!!</p>
            </div>
        );
    }
}
