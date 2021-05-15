import React from "react";
import './App.css';
import HealthInfo from "./HealthInfo";
import Info from "./Info";
import InfoOne from "./InfoOne";
import {Container, Row, Col, Navbar, Nav, NavDropdown} from "react-bootstrap";
import { BrowserRouter as Router, Switch, Link, Route } from "react-router-dom";
import HealthLogin from "./HealthLogin";

export default function App() {
  return (
    <Router>

              <Container fluid>
                  <Row>
                  <Col>
                  <Navbar bg="light" expand="lg">
                      <Navbar.Brand> <Link to="/">Health App</Link>  </Navbar.Brand>
                      <Navbar.Toggle aria-controls="basic-navbar-nav" />
                      <Navbar.Collapse id="basic-navbar-nav">
                          <Nav className="mr-auto">
                              <Nav.Link title="Home">
                              <Link to="/">Home</Link> </Nav.Link>
                              <NavDropdown title="Find" id="basic-nav-dropdown">
                                  <NavDropdown.Item><Link to="/login">Login</Link></NavDropdown.Item>
                                  <NavDropdown.Divider />
                                  <NavDropdown.Item ><Link to="/list">List</Link></NavDropdown.Item>
                              </NavDropdown>
                          </Nav>
                          {/*<Form inline>*/}
                          {/*    <FormControl type="text" placeholder="Search" className="mr-sm-2" />*/}
                          {/*    <Button variant="outline-success">Search</Button>*/}
                          {/*</Form>*/}
                      </Navbar.Collapse>
                  </Navbar>
                      </Col>
                  </Row>


              <Row>
              <Col>

              <Switch>
                <Route path="/" exact component={Info }/>
                <Route path="/list" exact component={HealthInfo}/>
                <Route path="/login" exact component={HealthLogin}/>
              </Switch>
              </Col>
              </Row>
              </Container>

      </Router>
  );
}


