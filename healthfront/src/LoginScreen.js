import React, {useRef, useState} from "react";

import {Form, InputGroup} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export default function LoginScreen () {
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         loading : false,
    //     };
    // }

    // componentDidMount() {
    //     this.setState({loading:false})
    // }
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const submitRef = useRef();

    function handleUsername (event) {
        setUsername(event.target.value);

    }
    function handlePassword (event) {
        setPassword(event.target.value);
        submitRef.current.disabled = event.target.value == '';
    }

    function  handleSubmit (){

    }

          return (
              <>
                  <form>
                      <div>
                          <input type="text" name="username" id="username-input"  onChange={handleUsername}/>
                          <input type="password" name="password" id="password-input" onChange = {handlePassword}/>
                          <input type="submit" disabled id="login-button" value="Submit" ref={submitRef}/>
                      </div>
                  </form>
              {/*<Form >*/}
              {/*        <Form.Group controlId="formBasicEmail">*/}
              {/*            <InputGroup className="mb-3">*/}
              {/*            <InputGroup.Prepend>*/}
              {/*                <InputGroup.Text id="basic-addon1">@UserName</InputGroup.Text>*/}
              {/*            </InputGroup.Prepend>*/}
              {/*            <Form.Control type="email" placeholder="Enter email" />*/}
              {/*            </InputGroup>*/}
              {/*            <Form.Text className="text-muted">*/}
              {/*                We'll never share your email with anyone else.*/}
              {/*            </Form.Text>*/}
              {/*        </Form.Group>*/}

              {/*        <Form.Group controlId="formBasicPassword">*/}
              {/*            <InputGroup className="mb-3">*/}
              {/*            <InputGroup.Prepend>*/}
              {/*                <InputGroup.Text id="basic-addon1">@Password</InputGroup.Text>*/}
              {/*            </InputGroup.Prepend>*/}
              {/*            <Form.Control type="password" placeholder="Password" />*/}
              {/*            </InputGroup>*/}
              {/*        </Form.Group>*/}
              {/*        <Form.Group controlId="formBasicCheckbox">*/}
              {/*            <Form.Check type="checkbox" label="Check me out" />*/}
              {/*        </Form.Group>*/}
              {/*        <Button variant="primary" type="submit" onClick= { () => this.doLogin()} >*/}
              {/*            Submit*/}
              {/*        </Button>*/}
              {/*    </Form>*/}
              </>
          )

}

