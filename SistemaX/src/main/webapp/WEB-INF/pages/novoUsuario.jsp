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
        <form action="addUsuario" method="post">
            
            <div class="dj-text__center carregaImagem margin">
                <img src="imagens/perfil-face.jpg" class="img-perfil__carregar" id="image"><br><br>
                <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-upload">Enviar foto</button>
                <br><br><br>
                <input type="file" class="dj-invisible inp-upload" name="foto" onchange="updateLogo(this)"/>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="nome" id="nome" required="" autofocus="">
                    <label class="mdl-textfield__label" for="nome">Nome de usuário</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="password" class="mdl-textfield__input" name="senha" required="" id="senha">
                    <label class="mdl-textfield__label" for="senha">Senha</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="email" required="" id="email">
                    <label class="mdl-textfield__label" for="email">Email</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="matricula" required="" maxlength="6" id="matricula">
                    <label class="mdl-textfield__label" for="matricula">Matrícula</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="tipo" required="" id="tipo" list="tipos" autocomplete="off">
                    <label class="mdl-textfield__label" for="tipo">Tipo de usuário</label>
                </div><br><br>
                <h6 id="result"></h6>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised">Cadastrar</button>
                    <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active dj-invisible" id="loading"></div>
                </div>
        </form>
            <br>
            <datalist id="tipos">
                <option value="ADMINISTRADOR"></option>
                <option value="ALUNO"></option>
                <option value="ASSISTENTE DE SALA"></option>
                <option value="MONITOR"></option>
                <option value="PROFESSOR"></option>
            </datalist>

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