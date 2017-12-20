"use strict";

$(document).ready( function() {
    $('div[w3-include-header]').load( $('div[w3-include-header]').attr('w3-include-header') );
    $('div[w3-include-footer]').load( $('div[w3-include-footer]').attr('w3-include-footer') );

    // ã????ư?? ????ޱ?
    $('body').on( 'click', '#btn1', function(e){
        $('#content').toggle();
    });
});
