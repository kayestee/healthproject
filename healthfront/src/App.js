import React from "react";
import './App.css';
import HealthInfo from "./HealthInfo";
import HealthFilter from "./HealthFilter"
import Info from "./Info";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import HealthLogin from "./HealthLogin";
import {
    Badge,
    Button,
    Col,
    Container,
    Form,
    FormControl,
    Jumbotron,
    Nav,
    Navbar,
    NavDropdown,
    Row
} from "react-bootstrap";



export default function App() {
  return (
    <Router>
                <Container maxwidth="sm" >
                  
                  <Row className="justify-content-md-center">
                  <Col>
                      <Navbar bg="light" expand="lg" sticky="top">
                          <Navbar.Brand href="/">Home</Navbar.Brand>
                          <Navbar.Toggle aria-controls="basic-navbar-nav" />
                          <Navbar.Collapse id="basic-navbar-nav">
                              <Nav className="mr-auto">
                                  <Nav.Link href="/" >Home</Nav.Link>
                                  <Nav.Link href="/list" >List</Nav.Link>
                                  <Nav.Link href="/login" >Login</Nav.Link>
                                  <Nav.Link href="/filter" >Filter</Nav.Link>
                                  {/*<NavDropdown title="Find" id="basic-nav-dropdown">*/}
                                  {/*    <NavDropdown.Item href="">Login</NavDropdown.Item>*/}
                                  {/*    <NavDropdown.Item href="">List</NavDropdown.Item>*/}

                                  {/*    <NavDropdown.Divider />*/}
                                  {/*    <NavDropdown.Item href="">Filter</NavDropdown.Item>*/}
                                  {/*</NavDropdown>*/}
                              </Nav>

                              <Form inline className="ri">
                                  <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                                  <Button variant="outline-success">Search</Button>
                              </Form>
                          </Navbar.Collapse>
                      </Navbar>
                      </Col>
                  </Row>
                    <Switch>
                        <Route path="/list" exact component={HealthInfo}/>
                        <Route path="/login" exact component={HealthLogin}/>
                        <Route path="/filter" exact component={HealthFilter}/>
                    </Switch>

              </Container>


      </Router>
  );
}


