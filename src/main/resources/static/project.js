//Calculator page
function selectAllTiller(source){
    checkboxes = document.getElementsByClassName('selectTiller');
    for(var i=0; i<checkboxes.length; i++){
        checkboxes[i].checked = source.checked
    }
}

function selectAllArtisan(source){
    checkboxes = document.getElementsByClassName('selectArtisan');
    for(var i=0; i<checkboxes.length; i++){
        checkboxes[i].checked = source.checked
    }
}

//Calendar page
$(document).ready(function() {
    $(function() {
        $( ".day" ).click(function(){
            $('#event-menu').slideToggle('slow');
       });
    });
})