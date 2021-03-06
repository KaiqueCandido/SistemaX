<%-- 
    Document   : managerUser
    Created on : 27/01/2016, 09:03:42
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <%@include file="head.jsp" %>
    <body>
        <%@include file="header.jsp" %>
        <div class="breadcrumb">
            <a href="home">Home</a>
            <label> ></label>
            <label>Gerenciar Feriados</label>
        </div>
        <%@include file="importarFeriado.jsp" %>
        <%@include file="novoFeriado.jsp" %>
        <div class="conteudo">
            <div class="crud-user">
                <div class="dj-float__left">
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin " onclick="adicionarFeriado()">
                        <img src="Icons/ic_add_black_24dp_2x.png" class="material-icons">
                    </button>
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin" disabled="" onclick="editarFeriado()" id="edit">
                        <img src="Icons/ic_edit_black_24dp_2x.png" class="material-icons">
                    </button>
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin" disabled="" id="remove" onclick="removerFeriado()">
                        <img src="Icons/trash.png" class="material-icons">
                    </button>
                </div>
                <div class="dj-text__right ">
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin" id="importa" onclick="importarFeriado()">
                        <img src="Icons/ic_file_upload_black_24dp_2x.png" class="material-icons">Importar Feriados
                    </button>
                </div>
                <br>
                <div class="calendario">
                    <div id="calendar"></div>                    
                </div>
            </div>
        </div>
        <form class="dj-invisible" action="removerFeriado" method="post">
            <input type="text" name="title" id="nomeFeriado">
            <input type="date" name="start" id="dataFeriado">
            <input type="submit" id="subRemoveFeriado">
        </form>
        <form class="dj-invisible" action="editarFeriado" method="post">
            <input type="text" name="title" id="nomeFeriado">
            <input type="text" name="start" id="dataFeriado">
            <input type="submit" id="subEditaFeriado">
        </form>
        
    </div>
</body>
</html>
