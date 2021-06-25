import React from "react";
import { fade, makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import MoreIcon from "@material-ui/icons/MoreVert";
import { ExitToApp } from "@material-ui/icons";
import { Email } from "@material-ui/icons";
import { Group } from "@material-ui/icons";
import { LocalHospital } from "@material-ui/icons";
import { Link } from "react-router-dom";

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
  const [mobileMoreAnchorEl, setMobileMoreAnchorEl] = React.useState(null);

  const isMobileMenuOpen = Boolean(mobileMoreAnchorEl);

  const handleMobileMenuClose = () => {
    setMobileMoreAnchorEl(null);
  };

  const handleMobileMenuOpen = (event) => {
    setMobileMoreAnchorEl(event.currentTarget);
  };

  const navLinkStyle = { color: "white" };
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
      <Link style={navLinkStyle} to="#6">
        <MenuItem style={{ backgroundColor: "#171515" }}>
          <LocalHospital style={{ marginRight: "6px" }} />
          ForDoctors
        </MenuItem>
      </Link>
      <Link style={navLinkStyle} to="#6">
        <MenuItem style={{ backgroundColor: "#171515" }}>
          <ExitToApp style={{ marginRight: "6px" }} />
          Login/Register
        </MenuItem>
      </Link>
      <Link style={navLinkStyle} to="/about">
        <MenuItem style={{ backgroundColor: "#171515" }}>
          <Group style={{ marginRight: "6px" }} />
          About-Us
        </MenuItem>
      </Link>
      <Link style={navLinkStyle} to="#3">
        <MenuItem style={{ backgroundColor: "#171515" }}>
          <Email style={{ marginRight: "6px" }} />
          Contact-Us
        </MenuItem>
      </Link>
    </Menu>
  );

  return (
    <div className={classes.grow}>
      <AppBar position="static" style={{ backgroundColor: "#171515" }}>
        <Toolbar>
          <Typography className={classes.title} variant="h6" noWrap>
            Book My Doctor
          </Typography>
          <div className={classes.grow} />
          <div className={classes.sectionDesktop}>
            <div
              style={{
                display: "flex",
                justifyContent: "space-evenly",
                width: "650px",
              }}
            >
              <Link style={navLinkStyle} to="/">
                <i
                  className="fa fa-home mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Home
              </Link>
              <Link style={navLinkStyle} to="#6">
                <i
                  className="fa fa-user-md mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                ForDoctors
              </Link>
              <Link style={navLinkStyle} to="#2">
                <i
                  className="fa fa-sign-in mr-1"
                  style={{ fontSize: "17px", color: "white" }}
                ></i>
                Login/Register
              </Link>
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
    </div>
  );
}
