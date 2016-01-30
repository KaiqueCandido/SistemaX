<%-- 
    Document   : index
    Created on : 26/01/2016, 18:23:28
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="dj-text__center">
        <h2>Sistema</h2>
        <div>
            <img src="Icons/symbol174.png" alt="logo" title="Sistema X" id="logoInicio">
        </div>
        <form action="logar" method="post">
            <h6>${erro}</h6>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="sample1" required="" name="usuarioOuEmail">
                <label class="mdl-textfield__label" for="sample1">Nome de usuário ou email</label>
            </div><br>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="password" id="sample2" required="" name="senha">
                <label class="mdl-textfield__label" for="sample2">Senha</label>
            </div><br><br>
            <div>
                <div class="swicth-center">
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect swicth" for="lembrar">
                        <input type="checkbox" id="lembrar" class="mdl-switch__input">
                        <span class="mdl-switch__label">Lembrar</span>
                    </label>
                </div>
                <div>
                    <a href="requisitarSenha" class="margin">Esqueci minha senha</a>
                    <input class="mdl-button mdl-js-button mdl-button--accent mdl-button--raised mdl-js-ripple-effect margin" type="submit" value="Login">
                </div>
        </form>
    </body>
</html>
