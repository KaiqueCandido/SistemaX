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
        select: function (start, end) {
            var title = prompt('Event Title:');
            var eventData;
            if (title) {
                eventData = {
                    title: title,
                    start: start,
                    end: end
                };
                $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
            }
            $('#calendar').fullCalendar('unselect');
        },
        editable: true,
        eventLimit: true,
        events: {
            url: 'getEventos.json'
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
    
    jQuery(".btn-upload2").click(function () {
        jQuery(".inp-upload2").trigger('click');
    });

    jQuery(".inp-upload2").change(function () {
        var arq = jQuery(".inp-upload2").val().replace(/^.*\\/, "");
        jQuery(".btn-upload2").text(arq);
    });

});

function escondeMenu() {
    $('.automatic').addClass('dj-invisible');
}


function adicionarUsuarioAjax() {

        $.ajax({
            url: "/AddUsuarioAjaxServlet",
            type: "POST",
            data: idClicado,
            processData: false,
            contentType: false,
            beforeSend: function () {

            },
            complete: function () {
                
            },
            success: function () {
                
            },
            error: function () {
                
            }
        });
}

function editarUsuario() {
    adicionarUsuario();
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

function notNull(x) {
    if (x !== '') {
        return true;
    } else {
        return false;
    }
}

function liberarBotoes(idUsuario) {

    if (idClicado === -1){
        $('#edit').removeAttr('disabled');
        $('#remove').removeAttr('disabled');
        $('#linha' + idUsuario).addClass('rowSelect');
        b = false;
    }else if (idUsuario !== idClicado) {
        $('#linha'+idClicado).removeClass('rowSelect');
        $('#linha'+idUsuario).addClass('rowSelect');
        b = false;
    }else {
        $('#linha'+idUsuario).removeClass('rowSelect');
        $('#edit').attr('disabled', '');
        $('#remove').attr('disabled', '');
        b = true;
    }

    idClicado = idUsuario;

    if (b){
        idClicado = -1;
    }
}

function setarCheckbox(idUsuario) {

    $('.checkAutomatic').removeAttr('checked');
    $('#checkbox' + idUsuario).attr('checked');

}

function removerUsuario(){
    
    b = window.confirm("Deseja realmente remover este usuário?");
    if (b){
        $('#removeUsuario').val(idClicado);
        $('#subRemoveUsuario').trigger('click');
    }
}