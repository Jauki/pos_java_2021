const onValidate = (elem) => {
    let ok = false;

    let value = elem.betrag.value;
    if(value == "" || isNaN(value)) {
        document.getElementById("errorValue").innerHTML = "Input is not Valid";
        document.getElementById("betrag").className += " is-invalid";
    } else {
        document.getElementById("errorValue").innerHTML = "";
        document.getElementById("betrag").className += " is-valid";
        ok = true;
    }
    return ok;
}

// Zusatz denk i
const shortSetter = (id_1, id_2) => {
    let first = document.getElementById(id_1)
    let sec = document.getElementById(id_2)
    let str = first.options[first.selectedIndex].value;
    sec.value = str;
}

const onSwap = () => {
    let elm1_long = document.getElementById("baseLong")
    let elm2_long = document.getElementById("resultLong")
    let swapVar = elm2_long.options[elm2_long.selectedIndex].value;
    elm2_long.value = elm1_long.options[elm1_long.selectedIndex].value;
    elm1_long.value = swapVar

    shortSetter("baseLong", "baseShort")
    shortSetter("resultLong", "resultShort")
}