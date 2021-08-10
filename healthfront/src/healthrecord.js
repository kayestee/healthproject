import React from "react";
import HealthDisplay from "./HealthDisplay";

export default class HealthRecord extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            item: props.item,
            id: props.id,
            recordname: props.recordname,
        }
    }


    render() {
        return (
            <>
                <HealthDisplay item={this.state.item} recordname={ this.state.item.status}/>
            </>
        );
    }
}




