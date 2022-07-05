function showMoreInput(value) {
    $(".aFacility").click(function (event) {
        let choice = $(this).attr("href");
        if (value !== "") {
            choice = value;
        }
        console.log(choice)
        event.preventDefault();
        switch (choice) {
            case "House":
                $("#tableInput" + choice).show();
                $("#tableInputRoom").hide();
                $("#tableInputVilla").hide();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
                break
            case "Room":
                $("#tableInputHouse").hide();
                $("#tableInput" + choice).show();
                $("#tableInputVilla").show();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
                break
            case "Villa":
                $("#tableInputHouse").show();
                $("#tableInputRoom").hide();
                $("#tableInput" + choice).show();
                $("#tableInputName").show();
                $("#tableInputName").text(choice);
                $("#inputFacilityHidden").val(choice)
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
console.log(value === "")
showMoreInput(value);