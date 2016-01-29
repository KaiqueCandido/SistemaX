<%-- 
    Document   : home
    Created on : 26/01/2016, 21:58:46
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
        <%@include file="header.jsp" %>
        <div class="breadcrumb ">
            <a href="home">Home</a>
        </div>
        <hr>
        <div class="conteudo">
            <h4>Funcionalidades</h4>
            <div class="conjunto">
                <ul>
                    <li>
                        <div class="funcionalidades">
                            <img src="imagens/logo.jpg" alt="funcionalidade" title="Gerenciar Usuário" class="img-funcionalidade">
                            <h6><a href="managerUser">Gerenciar Usuário</a></h6>
                        </div>
                    </li>
                    <li>
                        <div class="funcionalidades">
                            <img src="imagens/logo.jpg" alt="funcionalidade" title="Gerenciar Feriados" class="img-funcionalidade">
                            <h6><a href="managerHoliday">Gerenciar Feriados</a></h6>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
