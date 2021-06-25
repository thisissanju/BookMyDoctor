import React from "react";
import { Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import "./Header.css";

export default function header() {
  const navLinkStyle = { color: "white" };

  return (
    <>
      <Navbar
        bg="dark"
        variant="dark"
        expand="lg"
        style={{ textAlign: "center" }}
      >
        <Navbar.Brand href="#home" className="ml-2">
          {" "}
          <img
            className="mr-2"
            src={process.env.PUBLIC_URL + "/home/bmd-logo3.png"}
            alt="Second slide"
            style={{ height: "30px", width: "30px" }}
          />
          Book My Doctor
        </Navbar.Brand>
        <Nav>
          <Nav.Item className="nav-style">
            <i
              className="fa fa-plus"
              style={{ fontSize: "40px", color: "red" }}
            ></i>
          </Nav.Item>
        </Nav>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto mr-4" variant="light">
            <Nav.Link>
              <Link style={navLinkStyle} to="/">
                <i
                  className="fa fa-home mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Home
              </Link>
            </Nav.Link>
            <Nav.Link>
              <Link style={navLinkStyle} href="#6">
                <i
                  className="fa fa-user-md mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                ForDoctors
              </Link>
            </Nav.Link>
            <Nav.Link>
              <i
                className="fa fa-sign-in mr-1"
                style={{ fontSize: "17px", color: "white" }}
              ></i>
              <Link style={navLinkStyle} href="#2">
                Login/Register
              </Link>
            </Nav.Link>
            <Nav.Link>
              <Link style={navLinkStyle} to="/about">
                <i
                  className="fa fa-users mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                About-Us
              </Link>
            </Nav.Link>
            <Nav.Link>
              <Link style={navLinkStyle} href="#3">
                <i
                  className="fa fa-envelope mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Contact-Us
              </Link>
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    </>
  );
}
