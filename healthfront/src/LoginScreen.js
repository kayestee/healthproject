import React, {useState} from "react";

import {InputGroup, FormControl} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export default class LoginScreen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading : true,
        };
    }



    componentDidMount(){
        const reqOptions = {
            method: 'GET',
            headers : {'Content-Type': 'application/json'},
        };
        console.log(process.env.REACT_APP_HEALTHCHECK_URL)
        let fetchDomain = `http://${process.env.REACT_APP_HEALTHCHECK_URL}/healthcheck?format=`;
        console.log(fetchDomain)
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


    doToggle(){
        console.log('login')
    }

    render () {
          return (
              <>
              <div>
                  <InputGroup className="mb-3">
                      <InputGroup.Prepend>
                          <InputGroup.Text id="basic-addon1">@UserName</InputGroup.Text>
                      </InputGroup.Prepend>
                      <FormControl
                          placeholder="Username"
                          aria-label="Username"
                          aria-describedby="basic-addon1"
                      />
                  </InputGroup>
                  <InputGroup className="mb-3">
                      <InputGroup.Prepend>
                          <InputGroup.Text id="basic-addon1">@Password</InputGroup.Text>
                      </InputGroup.Prepend>
                      <FormControl
                          placeholder="Username"
                          aria-label="Username"
                          aria-describedby="basic-addon1"
                      />
                  </InputGroup>
                  <Button className=".btn-flat"
                          onClick={this.doToggle()}  id="submitlogin"> Login </Button>

              </div>
              </>
          )
        }
}

