<%-- 
    Document   : novoUsuario
    Created on : 27/01/2016, 14:50:14
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="automatic dj-invisible" id="editarUser">
    <div class="dj-modal__menu">
        <div class="dj-modal__title margin">
            <h4>Editar usu�rio</h4>
            <hr>
        </div>
        <div class="dj-text__center carregaImagem margin">
            <img src="imagens/perfil-face.jpg" class="img-perfil__carregar" id="image2"><br><br>
            <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-upload2">Enviar foto</button>
            <br><br><br>
            <form action="atualizarUsuarioAtual" method="post">
                <h6>${erro}</h6>
                <input type="file" class="dj-invisible inp-upload2" name="foto" onchange="updateLogoOldUser(this)"/>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="nome" id="sample1" required="" autofocus="" value=${usuarioSelecionado.nome}>
                    <label class="mdl-textfield__label" for="sample1">Nome de usu�rio</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="password" class="mdl-textfield__input" name="senha" id="sample2" required="" value=${usuarioSelecionado.senha}>
                    <label class="mdl-textfield__label" for="sample2">Senha</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="email" id="sample3" required="" value=${usuarioSelecionado.email}>
                    <label class="mdl-textfield__label" for="sample3">Email</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="matricula" id="sample4" required="" value=${usuarioSelecionado.matricula}>
                    <label class="mdl-textfield__label" for="sample4">Matr�cula</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="tipo" id="sample5" required="" value=${usuarioSelecionado.tipo}>
                    <label class="mdl-textfield__label" for="tipo">Tipo de usu�rio</label>
                </div><br><br>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised" onclick="editUser()">Alterar</button>
                </div>
            </form>

        </div>
    </div>
    <div class="dj-modal__backdrop"></div>
</div>
<script>
    function updateLogoOldUser(input) {
        var reader = new FileReader(input);
        reader.onload = function (e) {
            $("#image2").attr("src", e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
</script>