function showMoreInput(value) {
    $(".aFacility").click(function (event) {
        let choice = $(this).attr("href");
        if (value !== "") {
            choice = value;
        }
        event.preventDefault();
        switch (choice) {
            case "House":
                $("#tableInput" + choice).show();
                $("#tableInputRoom").hide();
                $("#tableInputVilla").hide();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
                document.getElementById("House").setAttribute("selected","true");
                document.getElementById("Room").removeAttribute("selected");
                document.getElementById("Villa").removeAttribute("selected");
                break
            case "Room":
                $("#tableInputHouse").hide();
                $("#tableInput" + choice).show();
                $("#tableInputVilla").hide();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
                document.getElementById("Room").setAttribute("selected","true");
                document.getElementById("House").removeAttribute("selected");
                document.getElementById("Villa").removeAttribute("selected");
                break
            case "Villa":
                $("#tableInputHouse").show();
                $("#tableInputRoom").hide();
                $("#tableInput" + choice).show();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
                document.getElementById("Villa").setAttribute("selected","true");
                document.getElementById("Room").removeAttribute("selected");
                document.getElementById("House").removeAttribute("selected");
                break
            default:
                $("#tableInputHouse").hide();
                $("#tableInputRoom").hide();
                $("#tableInputVilla").hide();
                $("#tableInputName").hide();
                break
        }
    })
}

$("#tableInputHouse").hide();
$("#tableInputRoom").hide();
$("#tableInputVilla").hide();
$("#tableInputName").hide();
let value = $("#inputFacilityHidden").val();
showMoreInput(value);