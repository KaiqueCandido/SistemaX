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
        <div class="breadcrumb ">
            <a href="home">Home  ></a><a href="managerUser">Gerenciar Usuário</a>
        </div>
        <%@include file="novoUsuario.jsp" %>
        <%@include file="editarUsuario.jsp" %>
        <div class="conteudo">
            <div class="crud-user">
                <div class="dj-float__left">
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin " onclick="adicionarUsuario()">
                        <img src="Icons/ic_add_black_24dp_2x.png" class="material-icons">
                    </button>
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin" disabled="">
                        <img src="Icons/ic_edit_black_24dp_2x.png" class="material-icons">
                    </button>
                    <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect mdl-button--raised margin" disabled="">
                        <img src="Icons/trash.png" class="material-icons">
                    </button>
                </div>
                <div class="dj-text__right menuSearch">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                         mdl-textfield--floating-label mdl-textfield--align-right dj-spacer__rigth--menor">
                        <label>Buscar Usuário</label>
                        <label class="mdl-button mdl-js-button mdl-button--icon"
                               for="searchUser">
                            <img src="Icons/ic_search_black_24dp_2x.png" class="material-icons">
                        </label>
                        <div class="mdl-textfield__expandable-holder">
                            <input class="mdl-textfield__input input-search" type="text" name="sample" id="searchUser" accesskey="b">
                        </div>
                    </div>
                </div>
            </div><br>
            <div class="dj-tabela__overflow">
                <table id="tabela" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp dj-tabela__big">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Papel</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuarios}" var="usuario">
                            <tr>
                                <td class="dj-size__small"><input type="checkbox" onclick="liberarButton(${usuario.id})" checked=""></td>
                                <td>${usuario.nome}</td>
                                <td>${usuario.email}</td>
                                <td>${usuario.tipo}</td>
                                <td>${usuario.status}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
