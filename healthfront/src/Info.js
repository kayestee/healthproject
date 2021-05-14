import React from "react";
import './App.css'

export default class Info extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items : [1,2,3,4,5,6],
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
