const fill = (elem, text) => {
    if(elem.value == "") {
        elem.value = text
    }
    elem.focus()
    elem.select()
}

const onValidate = (formElem) => {
    let ok = true;

    let firstname = formElem.firstname.value;
    if(firstname == "" || firstname.length < 3 || firstname.length > 20) {
        ok = false;
        document.getElementById("errFirstname").innerHTML = "* Please enter Firstname"
    } else {
        document.getElementById("errFirstname").innerHTML = ""
    }

    let lastname = formElem.lastname.value;
    if(lastname == "" || lastname.length < 3 || lastname.length > 20) {
        ok = false;
        document.getElementById("errLastname").innerHTML = "* Please enter Lastname"
    } else {
        document.getElementById("errLastname").innerHTML = ""
    }

    let age = formElem.age.value;
    if(isNan(age) || age < 1 || age > 120) {
        ok = false;
        document.getElementById("errAge").innerHTML = "* Please enter a valid age"
    } else {
        document.getElementById("errAge").innerHTML = ""
    }

    return ok
}

const fetchTable = () => {
    let url ="timeTable.html"
    fetch(url)
        .then(res => console.log(res))
        .then(text => {
            document.getElementById("tableContent").innerHTML = text;
        })
        .catch(err => console.log(err))
}

const fetchServlet = () => {
    // fetch is cross side
    let lastname = document.getElementsByName("lastname")[0].value;
    let firstname = document.getElementsByName("firstname")[0].value;
    let url = "TestServlet";
    fetch(url, {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded"  },
        body: "lastname=" + lastname +"&firstname=" + firstname
    })
        .then(res => res.json())
        .then(jsonObj => processJson(jsonObj))
        .catch(err => console.log(err))
}

const processJson = (jsonObj) => {
    let resultStr = jsonObj[0].nickname;
    document.getElementById("textContent").innerHTML = resultStr
}