/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('.dj-modal__backdrop').click(function () {
        escondeMenu();
    });

    $(document).keyup(function (evt) {

        if (evt.keyCode === 27) {
            escondeMenu();
        }
    });

    //upload de imagens
    jQuery(".btn-upload").click(function () {
        jQuery(".inp-upload").trigger('click');
    });

    jQuery(".inp-upload").change(function () {
        var arq = jQuery(".inp-upload").val().replace(/^.*\\/, "");
        jQuery(".btn-upload").text(arq);
    });

});

function escondeMenu() {
    $('.automatic').addClass('dj-invisible');
}

function adicionarUsuario() {
    $('#novoUser').removeClass('dj-invisible');
}

function editarUsuario() {
    $('#editarUser').removeClass('dj-invisible');
}

$(function () {
    $("#searchUser").keyup(function () {
        var index = $(this).parent().index();
        var nth = "#tabela td:nth-child(" + (index).toString() + ")";
        var valor = $(this).val().toUpperCase();
        $("#tabela tbody tr").show();
        $(nth).each(function () {
            if ($(this).text().toUpperCase().indexOf(valor) < 0) {
                $(this).parent().hide();
            }
        });
    });

    $("#searchUser").blur(function () {
        $(this).val("");
    });
});
