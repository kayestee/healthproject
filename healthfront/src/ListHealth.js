import React from "react";
import HealthRecord from "./healthrecord";

export default class ListHealth extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items : props.healthItems,
        };
    }

    render () {
          console.log(this.state.items)
          return (
              this.state.items.map((item) =>
                <HealthRecord id = {item.id} key={item.id} item={item} />
              ));
    }
}

