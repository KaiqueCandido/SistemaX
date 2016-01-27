/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    
    $('.dj-modal__backdrop').click(function () {
        $('.automatic').addClass('invisible');
    });
    
    $(document).keyup(function (evt) {

        if (evt.keyCode === 27) {
            $('.automatic').addClass('invisible');
        }
    });
});