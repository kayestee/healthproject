import React from "react";

import {Form, InputGroup} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export default class LoginScreen extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading : false,
        };
    }



    componentDidMount() {
        this.setState({loading:false})
    }

    doLogin(){
        // const reqOptions = {
        //     method: 'GET',
        //     headers : {'Content-Type': 'application/json'},
        // };
        // console.log(process.env.REACT_APP_HEALTHCHECK_URL)
        // let fetchDomain = `http://${process.env.REACT_APP_HEALTHCHECK_URL}/healthcheck?format=`;
        // console.log(fetchDomain)
        // fetch(fetchDomain, reqOptions)
        //     .then(response => response.json())
        //     .then((result) => {
        //             this.setState({items: result, loading: false});
        //         },
        //         (error) => {
        //             this.setState({fetchError: error, loading:false});
        //         }
        //     )
        alert('login')
    }




    render () {
          return (
              <>
              <Form >
                      <Form.Group controlId="formBasicEmail">
                          <InputGroup className="mb-3">
                          <InputGroup.Prepend>
                              <InputGroup.Text id="basic-addon1">@UserName</InputGroup.Text>
                          </InputGroup.Prepend>
                          <Form.Control type="email" placeholder="Enter email" />
                          </InputGroup>
                          <Form.Text className="text-muted">
                              We'll never share your email with anyone else.
                          </Form.Text>
                      </Form.Group>

                      <Form.Group controlId="formBasicPassword">
                          <InputGroup className="mb-3">
                          <InputGroup.Prepend>
                              <InputGroup.Text id="basic-addon1">@Password</InputGroup.Text>
                          </InputGroup.Prepend>
                          <Form.Control type="password" placeholder="Password" />
                          </InputGroup>
                      </Form.Group>
                      <Form.Group controlId="formBasicCheckbox">
                          <Form.Check type="checkbox" label="Check me out" />
                      </Form.Group>
                      <Button variant="primary" type="submit" onClick= { () => this.doLogin()} >
                          Submit
                      </Button>
                  </Form>
              </>
          )
        }
}

