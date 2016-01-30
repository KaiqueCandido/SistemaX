<%-- 
    Document   : novoUsuario
    Created on : 27/01/2016, 14:50:14
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="automatic dj-invisible" id="novoUser">
    <div class="dj-modal__menu">
        <div class="dj-modal__title margin">
            <h4>Novo usu�rio</h4>
            <hr>
        </div>
        <div class="dj-text__center carregaImagem margin">
            <img src="imagens/perfil-face.jpg" class="img-perfil__carregar" id="image"><br><br>
            <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-upload">Enviar foto</button>
            <br><br><br>
            <form action="adicionarUsuario()" method="post">
                <h6 class="result">${erro}</h6>
                <input type="file" class="dj-invisible inp-upload" name="foto" onchange="updateLogo(this)"/>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="nome" id="sample1" required="" autofocus="" id="nome">
                    <label class="mdl-textfield__label" for="sample1">Nome de usu�rio</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="password" class="mdl-textfield__input" name="senha" id="sample2" required="" id="senha">
                    <label class="mdl-textfield__label" for="sample2">Senha</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="email" id="sample3" required="" id="email">
                    <label class="mdl-textfield__label" for="sample3">Email</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="matricula" id="sample4" required="" maxlength="6" id="matricula">
                    <label class="mdl-textfield__label" for="sample4">Matr�cula</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="tipo" id="sample5" required="" id="tipo" list="tipos">
                    <label class="mdl-textfield__label" for="tipo">Tipo de usu�rio</label>
                </div><br><br>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised" onclick="adicionarUsuario()">Cadastrar</button>
                </div>
                <datalist id="tipos">
                    <option value="ADMINISTRADOR"></option>
                    <option value="ALUNO"></option>
                    <option value="ASSISTENTE DE SALA"></option>
                    <option value="MONITOR"></option>
                    <option value="PROFESSOR"></option>
                </datalist>
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