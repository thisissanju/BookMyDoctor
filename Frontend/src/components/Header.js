import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import MoreIcon from "@material-ui/icons/MoreVert";
import AccountCircle from "@material-ui/icons/AccountCircle";
import { ExitToApp } from "@material-ui/icons";
import { Email } from "@material-ui/icons";
import { Group } from "@material-ui/icons";
import { LocalHospital } from "@material-ui/icons";
import { Link } from "react-router-dom";
import HomeIcon from "@material-ui/icons/Home";
import { Avatar } from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    display: "none",
    [theme.breakpoints.up("sm")]: {
      display: "block",
    },
  },

  inputRoot: {
    color: "inherit",
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("md")]: {
      width: "20ch",
    },
  },
  sectionDesktop: {
    display: "none",
    [theme.breakpoints.up("md")]: {
      display: "flex",
    },
  },
  sectionMobile: {
    display: "flex",
    [theme.breakpoints.up("md")]: {
      display: "none",
    },
  },
}));

export default function Header1() {
  const classes = useStyles();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);
  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);
  const isMenuOpen = Boolean(anchorEl);

  const handleMobileMenuClose = () => {
    setMobileMoreAnchorEl(null);
  };

  const handleMobileMenuOpen = (event) => {
    setMobileMoreAnchorEl(event.currentTarget);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
    handleMobileMenuClose();
  };

  const navLinkStyle = { color: "white" };
  const loggedIn = false;
  const menuId = "primary-search-account-menu";

  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={menuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMenuOpen}
      onClose={handleMenuClose}
    >
      <MenuItem onClick={handleMenuClose}>Profile</MenuItem>
      <MenuItem onClick={handleMenuClose}>My account</MenuItem>
    </Menu>
  );
  const mobileMenuId = "primary-search-account-menu-mobile";
  const renderMobileMenu = (
    <Menu
      anchorEl={mobileMoreAnchorEl}
      anchorOrigin={{ vertical: "top", horizontal: "right" }}
      id={mobileMenuId}
      keepMounted
      transformOrigin={{ vertical: "top", horizontal: "right" }}
      open={isMobileMenuOpen}
      onClose={handleMobileMenuClose}
    >
      <Link style={navLinkStyle} to="/">
        <MenuItem
          onClick={handleMenuClose}
          style={{ backgroundColor: "#171515" }}
        >
          <HomeIcon style={{ marginRight: "6px" }} />
          Home
        </MenuItem>
      </Link>
      {!loggedIn && (
        <Link style={navLinkStyle} to="#6">
          <MenuItem
            onClick={handleMenuClose}
            style={{ backgroundColor: "#171515" }}
          >
            <LocalHospital style={{ marginRight: "6px" }} />
            ForDoctors
          </MenuItem>
        </Link>
      )}
      <Link style={navLinkStyle} to="#6">
        <MenuItem
          onClick={handleMenuClose}
          style={{ backgroundColor: "#171515" }}
        >
          <LocalHospital style={{ marginRight: "6px" }} />
          BookAppointment
        </MenuItem>
      </Link>
      {!loggedIn && (
        <Link style={navLinkStyle} to="#6">
          <MenuItem
            onClick={handleMenuClose}
            style={{ backgroundColor: "#171515" }}
          >
            <ExitToApp style={{ marginRight: "6px" }} />
            Login/Register
          </MenuItem>
        </Link>
      )}
      <Link style={navLinkStyle} to="/about">
        <MenuItem
          onClick={handleMenuClose}
          style={{ backgroundColor: "#171515" }}
        >
          <Group style={{ marginRight: "6px" }} />
          About-Us
        </MenuItem>
      </Link>
      <Link style={navLinkStyle} to="#3">
        <MenuItem
          onClick={handleMenuClose}
          style={{ backgroundColor: "#171515" }}
        >
          <Email style={{ marginRight: "6px" }} />
          Contact-Us
        </MenuItem>
      </Link>
    </Menu>
  );

  let width = "580px";
  if (!loggedIn) width = "750px";

  return (
    <div className={classes.grow}>
      <AppBar position="static" style={{ backgroundColor: "#171515" }}>
        <Toolbar>
          <Avatar
            className="ml-5"
            style={{ marginLeft: "50px" }}
            src={process.env.PUBLIC_URL + "/home/doclogo.png"}
            variant="square"
            alt="Logo"
          />
          <Typography
            style={{
              fontFamily: "consolas",
              fontSize: "30px",
            }}
            className={classes.title + " ml-2"}
            variant="h6"
            noWrap
          >
            BookMyDoctor
          </Typography>
          <div className={classes.grow} />
          <div className={classes.sectionDesktop}>
            <div
              style={{
                display: "flex",
                justifyContent: "space-evenly",
                width: width,
              }}
            >
              <Link style={navLinkStyle} to="/">
                <i
                  className="fa fa-home mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Home
              </Link>
              {!loggedIn && (
                <Link style={navLinkStyle} to="#6">
                  <i
                    className="fa fa-user-md mr-1"
                    style={{ fontSize: "17px", color: "white" }}
                  ></i>
                  ForDoctors
                </Link>
              )}
              <Link style={navLinkStyle} to="#6">
                <i
                  className="fa fa-user-md mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                BookAppointment
              </Link>
              {!loggedIn && (
                <Link style={navLinkStyle} to="#2">
                  <i
                    className="fa fa-sign-in mr-1"
                    style={{ fontSize: "17px", color: "white" }}
                  ></i>
                  Login/Register
                </Link>
              )}
              <Link style={navLinkStyle} to="/about">
                <i
                  className="fa fa-users mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                About-Us
              </Link>
              <Link style={navLinkStyle} to="#3">
                <i
                  className="fa fa-envelope mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Contact-Us
              </Link>
              {loggedIn && <AccountCircle onClick={handleProfileMenuOpen} />}
            </div>
          </div>

          <div className={classes.sectionMobile}>
            <IconButton
              aria-label="show more"
              aria-controls={mobileMenuId}
              aria-haspopup="true"
              onClick={handleMobileMenuOpen}
              color="inherit"
            >
              <MoreIcon />
            </IconButton>
          </div>
        </Toolbar>
      </AppBar>
      {renderMobileMenu}
      {renderMenu}
    </div>
  );
}
