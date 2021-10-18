const fetchStudents = () => {
    fetch('StudentController')
        .then(res => res.json())
        .then(jsonObj => processJSON(jsonObj))
        .catch(err => console.log(err))
}

const processJSON = (jsonObj) => {
    let select = document.getElementById('secletor')
    select.innerHTML = ""
    jsonObj.forEach(obj => {
        let opt = document.createElement('option')
        opt.innerHTML = "" + obj.name + " " + obj.suname
        select.appendChild(opt)
    })
}

function filterMethode() {
    let filter = document.getElementById('search').value
    fetch('StudentController', {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded"  },
        body: "filter=" + filter
    }).then(res => res.json())
        .then(jsonObj => processJSON(jsonObj))
        .catch(err => console.log(err))
}

const detail = (elm) => {
    let selected = elm.options[elm.selectedIndex].value
    //let selected = $("#secletor :selected").text()
    fetch('StudentController', {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded"  },
        body: "name=" + selected
    }).then(res => res.json())
        .then(jsonObj => displayDetail(jsonObj))
}


const displayDetail = (jsonObj) => {
    let div = document.getElementById('detail')
    div.style.display = "block"
    // make own class but is overkill
    let name = document.getElementById('name')
    let className = document.getElementById('class')
    let age = document.getElementById('age')
    let catNo = document.getElementById('catNo')
    let birthDate = document.getElementById('birthDate')

    let date = new Date(jsonObj.birthDate)
    let now = new Date().getFullYear()

    name.innerHTML = jsonObj.name + " " + jsonObj.suname
    className.innerHTML = jsonObj.className
    age.innerHTML = (now - date.getFullYear()) + " Jahre"
    catNo.innerHTML = "Katalognummer: " + jsonObj.catNo
    birthDate.innerHTML = date.toLocaleDateString()
}





window.onload = fetchStudents()