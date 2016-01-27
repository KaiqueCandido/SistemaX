<%-- 
    Document   : index
    Created on : 26/01/2016, 18:23:28
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="dj-text__center">
        <br>
        <div>
            <img src="imagens/logo.jpg" alt="logo" title="Sistema X" id="logoInicio">
        </div>
        <h1>${login} Sistema X</h1>
        <form action="logar" method="post">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="sample1" required="" name="usuarioOuEmail">
                <label class="mdl-textfield__label" for="sample1">Nome de usuário ou email</label>
            </div><br><br>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="password" id="sample2" required="" name="senha">
                <label class="mdl-textfield__label" for="sample2">Senha</label>
            </div><br><br>
            <div>
                <a href="requisitarSenha" class="margin">Esqueci minha senha</a>
                <input type="checkbox" id="lembrar" class="">
                <label for="lembrar">Lembrar</label><br>
                <input class="mdl-button mdl-js-button mdl-button--accent mdl-button--raised mdl-js-ripple-effect margin" type="submit" value="Login">
            </div>
        </form>
    </body>
</html>
