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


function adicionarUsuarioAjax() {

    var nome = $("#nome").val();
    var senha = $("#senha").val();
    var email = $("#email").val();
    var matricula = $("#matricula").val();
    var tipo = $("#tipo").val();
    var foto = $(".inp-upload").val();

    console.log(nome);

    if (notNull(nome) && notNull(senha) && notNull(email) && notNull(matricula) && notNull(tipo)) {
        console.log('Passou da verificação');
        $('#loading').removeClass('dj-invisible');

        var usuario = new FormData();

        usuario.append('nome', nome);
        usuario.append('senha', senha);
        usuario.append('email', email);
        usuario.append('matricula', matricula);
        usuario.append('tipo', tipo);
        usuario.append('foto', foto);

        $.ajax({
            url: "addUsuarioAjax",
            type: "POST",
            data: usuario,
            processData: false,
            contentType: false,
            beforeSend: function () {

            },
            complete: function () {
                console.log('Função completa');
            },
            success: function (res) {
                console.log(res);
                $('#loading').addClass('dj-invisible');
            },
            error: function (res) {
                console.log(res);
                $('#loading').addClass('dj-invisible');
            }
        });
    } else {
        console.log('algum deu erro');
        if (!notNull(nome)) {
            alert('Preencha nome');
            $('#nome').focus();
        }
        else if (!notNull(senha)) {
            alert('Insira uma senha válida');
            $('#senha').focus();
        }
        else if (!notNull(email)) {
            alert('Insira um email válido');
            $('#email').focus();
        }
        else if (!notNull(matricula)) {
            alert('Insira uma matrícula');
            $('#matricula').focus();
        }
        else {
            alert('Insira o tipo de usuário');
            $('#tipo').focus();
        }
    }
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

function notNull(x) {
    if (x !== '') {
        return true;
    } else {
        return false;
    }
}

$(document).ready(function () {

    $('#calendar').fullCalendar({
        header: {
            left: 'Anterior,Proximo today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        defaultDate: '2016-01-12',
        selectable: true,
        selectHelper: true,
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
        eventLimit: true, // allow "more" link when too many events
        events: [
            {
                title: 'All Day Event',
                start: '2016-01-01'
            },
            {
                title: 'Long Event',
                start: '2016-01-07',
                end: '2016-01-10'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2016-01-09T16:00:00'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2016-01-16T16:00:00'
            },
            {
                title: 'Conference',
                start: '2016-01-11',
                end: '2016-01-13'
            },
            {
                title: 'Meeting',
                start: '2016-01-12T10:30:00',
                end: '2016-01-12T12:30:00'
            },
            {
                title: 'Lunch',
                start: '2016-01-12T12:00:00'
            },
            {
                title: 'Meeting',
                start: '2016-01-12T14:30:00'
            },
            {
                title: 'Happy Hour',
                start: '2016-01-12T17:30:00'
            },
            {
                title: 'Dinner',
                start: '2016-01-12T20:00:00'
            },
            {
                title: 'Birthday Party',
                start: '2016-01-13T07:00:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2016-01-28'
            }
        ]
    });

});