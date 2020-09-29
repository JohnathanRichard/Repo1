// ! Working don't change !!!
let a = Document.getElementsByName("uname");

function ValidateEmail(currObjThatIClicked) {
  console.log(currObjThatIClicked.type + " : " + currObjThatIClicked.id);

  var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  if (currObjThatIClicked.value.match(mailformat)) {
    document.getElementById("error-display-id").innerHTML =
      "Valid email address!";
    document.form1.currObjThatIClicked;
    return true;
  } else {
    document.getElementById("error-display-id").innerHTML =
      " Invalid email address!";

    document.form1.email1.focus();
    return false;
  }
}

var input = document.getElementsByName("email1");

input.addEventListener("Keydown", function (event) {
  console.log(event.keyCode);

  if (event.keyCode === 13);
  {
    event.preventDefault();
    document.getElementById("btn 11").click();
  }
});

function validatingUserName() {
  if (A =="test") {
    alert(Hi test")
  }
}
