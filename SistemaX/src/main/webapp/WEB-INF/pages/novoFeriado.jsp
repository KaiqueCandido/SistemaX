<%-- 
    Document   : novoUsuario
    Created on : 27/01/2016, 14:50:14
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="automatic dj-invisible" id="novoFeriado">
    <div class="dj-modal__menu">
        <div class="dj-modal__title margin">
            <h4>Novo usuário</h4>
            <hr>
        </div>
        <form action="novoFeriado" method="post">
            <div class="dj-text__center carregaImagem margin">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="text" class="mdl-textfield__input" name="title" id="nome" required="" autofocus="">
                    <label class="mdl-textfield__label" for="nome">Nome do feriado</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input type="date" class="mdl-textfield__input" name="start" required="" id="senha">
                    <label class="mdl-textfield__label" for="data"></label>
                </div><br>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised">Cadastrar</button>
                    <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active dj-invisible" id="loading"></div>
                </div>
        </form>
        <br>            

    </div>
</div>
<div class="dj-modal__backdrop"></div>
</div>
