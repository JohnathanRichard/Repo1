function ValidateEmail(currObjThatIClicked)
{

    console.log(currObjThatIClicked.type +" : "+ currObjThatIClicked.id);


     var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if(currObjThatIClicked.value.match(mailformat))
    {
        document.getElementById('error-display-id').innerHTML = 'valid email address!';
    document.form1.currObjThatIClicked;
    return true;
    }
    else
    {
    document.getElementById('error-display-id').innerHTML = ' invalid email address!';

    document.form1.email1.focus();
    return false;
    }
}