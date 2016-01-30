<%-- 
    Document   : header
    Created on : 26/01/2016, 22:32:32
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<header class="mdl-layout__header">
    <div class="menuSistema">
        <img id="logoHome" src="Icons/symbol174.png" alt="foto da logo" title="Sistema X">
        <div class="dj-float__right">
            <h4 class="mdl-layout__title">Sistema X</h4>
            <h6>Logado como ${usuarioLogado.tipo}</h6>
        </div>
    </div>
    <div class="menuUsuario dj-text__right">
        <div class="dj-float__left">
            <h4>${usuarioLogado.nome}</h4>
            <a href="#" onclick="editarUsuario()">Editar Perfil</a><label> |</label>
            <a href="deslogar">Sair</a>
        </div>
        <div class="">
            <img src="imagens/perfil-face.jpg" alt="foto do perfil" title="${usuarioLogado.nome}" class="img-perfil__home">
        </div>
    </div>
</header>