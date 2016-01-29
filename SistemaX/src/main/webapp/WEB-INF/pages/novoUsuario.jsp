<%-- 
    Document   : novoUsuario
    Created on : 27/01/2016, 14:50:14
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="automatic dj-invisible" id="novoUser">
    <div class="dj-modal__menu">
        <div class="dj-modal__title margin">
            <h4>Novo usuário</h4>
            <hr>
        </div>
        <div class="dj-text__center carregaImagem margin">
            <img src="imagens/perfil-face.jpg" class="img-perfil__carregar" id="image"><br><br>
            <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-upload">Enviar foto</button>
            <br><br><br>
            <form action="addUsuario" method="post">
                <input type="file" class="dj-invisible inp-upload" name="foto" onchange="updateLogo(this)"/>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="nome" id="sample1" required="" autofocus="">
                    <label class="mdl-textfield__label" for="sample1">Nome de usuário</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="password" class="mdl-textfield__input" name="senha" id="sample2" required="">
                    <label class="mdl-textfield__label" for="sample2">Senha</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="email" id="sample3" required="">
                    <label class="mdl-textfield__label" for="sample3">Email</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="matricula" id="sample4" required="">
                    <label class="mdl-textfield__label" for="sample4">Matrícula</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="tipo" id="sample5" required="">
                    <label class="mdl-textfield__label" for="tipo">Tipo de usuário</label>
                </div><br><br>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised">Cadastrar</button>
                </div>
            </form>

        </div>
    </div>
    <div class="dj-modal__backdrop"></div>
</div>
<script>
    function updateLogo(input) {
        var reader = new FileReader(this);
        reader.onload = function (e) {
            $("#image").attr("src", e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
</script>