function showMoreInput(choice) {
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
                $("#tableInputVilla").hide();
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
}

$("#tableInputHouse").hide();
$("#tableInputRoom").hide();
$("#tableInputVilla").hide();
$("#tableInputName").hide();
let choice = $("#inputFacilityHidden").val();
$(document).ready(function () {
    showMoreInput(choice);
})
