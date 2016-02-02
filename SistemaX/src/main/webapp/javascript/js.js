/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('#calendar').fullCalendar({
        ignoreTimezone: false,
        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
        dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
        buttonText: {
            today: "Hoje",
            month: "Mês",
            week: "Semana",
            day: "Dia"
        },
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        selectable: true,
        select: function (start, end, event) {
            fecharBotoesFeriados();
        },
        editable: true,
        eventLimit: true,
        events: {
            url: 'getEventos.json'
        },
        eventClick: function (event, element) {

            if (event) {
                var moment = $('#calendar').fullCalendar('getDate').format();
                alert(moment.year());
                
                liberarBotoesFeriados();
                $('#nomeFeriado').val(event.title);
                $('#dataFeriado').val(data);
                alert($('#nomeFeriado').val());
                alert($('#dataFeriado').val());
            }
        }

    });


    idClicado = -1;
    clique = 0;


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

    jQuery(".btn-upload__perfil").click(function () {
        jQuery(".inp-upload__perfil").trigger('click');
    });

    jQuery(".inp-upload__perfil").change(function () {
        var arq = jQuery(".inp-upload__perfil").val().replace(/^.*\\/, "");
        jQuery(".btn-upload").text(arq);
    });

    jQuery(".btn-upload2").click(function () {
        jQuery(".inp-upload2").trigger('click');
    });

    jQuery(".inp-upload2").change(function () {
        var arq = jQuery(".inp-upload2").val().replace(/^.*\\/, "");
        jQuery(".btn-upload2").text(arq);
    });

    //upload do csv
    jQuery(".btn-uploadCsv").click(function () {
        jQuery(".inp-uploadCsv").trigger('click');
    });

    jQuery(".inp-uploadCsv").change(function () {
        var arq = jQuery(".inp-uploadCsv").val().replace(/^.*\\/, "");
        jQuery(".btn-uploadCsv").text(arq);
    });

});

function escondeMenu() {
    $('.automatic').addClass('dj-invisible');
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


function adicionarUsuario() {
    $('#novoUser').removeClass('dj-invisible');
}

function importarFeriado() {
    $('#importarFeriado').removeClass('dj-invisible');
}

function adicionarFeriado() {
    $('#novoFeriado').removeClass('dj-invisible');
}

function editarFeriado() {
    $('#subEditaFeriado').trigger('click');
}

function removerFeriado() {
    $('#subRemoveFeriado').trigger('click');
}

function notNull(x) {
    if (x !== '') {
        return true;
    } else {
        return false;
    }
}

function liberarBotoes(idUsuario) {

    if (idClicado === -1) {
        $('#edit').removeAttr('disabled');
        $('#remove').removeAttr('disabled');
        $('#linha' + idUsuario).addClass('rowSelect');
        b = false;
    } else if (idUsuario !== idClicado) {
        $('#linha' + idClicado).removeClass('rowSelect');
        $('#linha' + idUsuario).addClass('rowSelect');
        b = false;
    } else {
        $('#linha' + idUsuario).removeClass('rowSelect');
        $('#edit').attr('disabled', '');
        $('#remove').attr('disabled', '');
        b = true;
    }

    idClicado = idUsuario;

    if (b) {
        idClicado = -1;
    }
}

function setarCheckbox(idUsuario) {

    $('.checkAutomatic').removeAttr('checked');
    $('#checkbox' + idUsuario).attr('checked');

}

function removerUsuario() {

    b = window.confirm("Deseja realmente remover este usuário?");
    if (b) {
        $('#removeUsuario').val(idClicado);
        $('#subRemoveUsuario').trigger('click');
    }
}

function liberarBotoesFeriados() {

    $('#edit').removeAttr('disabled');
    $('#remove').removeAttr('disabled');
}

function fecharBotoesFeriados() {
    $('#edit').attr("disabled", " ");
    $('#remove').attr("disabled", " ");
}