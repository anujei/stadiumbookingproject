@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap");
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

body {
  font-family: "Roboto", sans-serif;
  font-size: 0.925rem;
}

a {
  text-decoration: none;
}

.container {
  width: 1170px;
  position: relative;
  margin-left: auto;
  margin-right: auto;
  padding-left: 15px;
  padding-right: 15px;
}

.navbar,
.navbar > .container {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: space-between;
}
@media (max-width: 768px) {
  .navbar,
.navbar > .container {
    display: block;
  }
}

.navbar {
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
  background-color: #fff;
  padding: 1rem 1.15rem;
  border-bottom: 1px solid #eceef3;
  /*
  |-----------------------------------
  | Start navbar logo or brand etc..
  |-----------------------------------
  */
  /*
  |-----------------------------------
  | Start navbar menu
  |-----------------------------------
  */
}
@media (min-width: 576px) {
  .navbar .container {
    max-width: 540px;
  }
}
@media (min-width: 768px) {
  .navbar .container {
    max-width: 720px;
  }
}
@media (min-width: 992px) {
  .navbar .container {
    max-width: 960px;
  }
}
@media (min-width: 1200px) {
  .navbar .container {
    max-width: 1140px;
  }
}
.navbar .navbar-header {
  display: flex;
  align-items: center;
}
@media (max-width: 768px) {
  .navbar .navbar-header {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    flex-direction: row-reverse;
  }
}
.navbar .navbar-header .navbar-toggler {
  cursor: pointer;
  border: none;
  display: none;
  outline: none;
}
@media (max-width: 768px) {
  .navbar .navbar-header .navbar-toggler {
    display: block;
  }
}
.navbar .navbar-header .navbar-toggler span {
  height: 2px;
  width: 22px;
  background-color: #929aad;
  display: block;
}
.navbar .navbar-header .navbar-toggler span:not(:last-child) {
  margin-bottom: 0.2rem;
}
.navbar .navbar-header > a {
  font-weight: 500;
  color: #3c4250;
}
.navbar .navbar-menu {
  display: flex;
  align-items: center;
  flex-basis: auto;
  flex-grow: 1;
}
@media (max-width: 768px) {
  .navbar .navbar-menu {
    display: none;
    text-align: center;
  }
}
.navbar .navbar-menu .navbar-nav {
  margin-left: auto;
  flex-direction: row;
  display: flex;
  padding-left: 0;
  margin-bottom: 0;
  list-style: none;
}
@media (max-width: 768px) {
  .navbar .navbar-menu .navbar-nav {
    width: 100%;
    display: block;
    border-top: 1px solid #eee;
    margin-top: 1rem;
  }
}
.navbar .navbar-menu .navbar-nav > li > a {
  color: #3c4250;
  text-decoration: none;
  display: inline-block;
  padding: 0.5rem 1rem;
}
.navbar .navbar-menu .navbar-nav > li > a:hover {
  color: #66f;
}
@media (max-width: 768px) {
  .navbar .navbar-menu .navbar-nav > li > a {
    border-bottom: 1px solid #eceef3;
  }
}
.navbar .navbar-menu .navbar-nav > li.active a {
  color: #66f;
}
.navbar .navbar-menu .navbar-nav .navbar-dropdown .dropdown {
  list-style: none;
  position: absolute;
  top: 150%;
  left: 0;
  background-color: #fff;
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  min-width: 160px;
  width: auto;
  white-space: nowrap;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
  z-index: 99999;
  border-radius: 0.75rem;
  display: none;
}
@media (max-width: 768px) {
  .navbar .navbar-menu .navbar-nav .navbar-dropdown .dropdown {
    position: relative;
    box-shadow: none;
  }
}
.navbar .navbar-menu .navbar-nav .navbar-dropdown .dropdown li a {
  color: #3c4250;
  padding: 0.25rem 1rem;
  display: block;
}
.navbar .navbar-menu .navbar-nav .navbar-dropdown .dropdown.show {
  display: block !important;
}
.navbar .navbar-menu .navbar-nav .dropdown > .separator {
  height: 1px;
  width: 100%;
  margin-top: 9px;
  margin-bottom: 9px;
  background-color: #eceef3;
}
.navbar .navbar-dropdown {
  position: relative;
}

.navbar .navbar-header > a span {
  color: #66f;
}

.navbar .navbar-header h4 {
  font-weight: 500;
  font-size: 1.25rem;
}
@media (max-width: 768px) {
  .navbar .navbar-header h4 {
    font-size: 1.05rem;
  }
}
