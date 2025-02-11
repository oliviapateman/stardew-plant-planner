$(document).ready(function() {
//Calendar Page
    $(function() {
        $( ".day" ).click(function(){
            $('#event-menu').slideToggle('slow');
       });
    });

//Calculator Page
    $('#selectAllTiller').click(function () {
        $('.selectTiller').prop('checked', $(this).prop("checked"));
    });

    $('#selectAllArtisan').click(function () {
        $('.selectArtisan').prop('checked', $(this).prop("checked"));
    });

})
