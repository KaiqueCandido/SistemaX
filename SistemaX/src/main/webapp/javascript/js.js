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
        if (!notNull(nome)){
            alert('Preencha nome');
            $('#nome').focus();
        }
        else if (!notNull(senha)){
            alert('Insira uma senha válida');
            $('#senha').focus();
        }
        else if (!notNull(email)){
            alert('Insira um email válido');
            $('#email').focus();
        }
        else if (!notNull(matricula)){
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

function notNull(x){
    if(x !== ''){
        return true;
    }else{
        return false;
    }
}