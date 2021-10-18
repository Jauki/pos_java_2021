const onButtonClick = () => {
    // alert("Hello World")
    // console.log('Button clicked')
    // if(confirm("continue?") == true) {
    //     alert("Continue")
    // }
    const months1 = ["Jan", "Feb", "Mar"];
    const months2 = ["Apr", "May", "Jun"];
    const months3 = months1.concat(months2, "Dec")

    // if (prompt("Continue y/n", 'y') == 'y'){
    //     alert("continue");
    // }
    alert(months3.join(" - "))
}