<%-- 
    Document   : novoUsuario
    Created on : 27/01/2016, 14:50:14
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="automatic dj-invisible" id="importarFeriado">
    <div class="dj-modal__menu">
        <div class="dj-modal__title margin">
            <h4>Importar Feriado</h4>
            <hr>
        </div>
        <div class="dj-text__center carregaImagem margin">        <br>
            <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-uploadCsv">Upload Arquivo CSV</button>            
            <form action="openCSV" method="post" enctype="multipart/form-data">
                <input  type="file" class="dj-invisible inp-uploadCsv" onchange="updateCaminho(this)" name="arquivoCSV"/><br>
                <div class="swicth-center">
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="sobrescrever">
                        <input type="checkbox" class="mdl-switch__input" name="sobrescrever" id="sobrescrever">
                        <span class="mdl-switch__label">Sobrescrever feriados</span>
                    </label>
                </div><br>
                <div class="botoes-fechar dj-text__right">
                    <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised">Importar</button>
                    <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active dj-invisible" id="loading"></div>
                </div>            
            </form>
        </div>
    </div>
    <div class="dj-modal__backdrop"></div>
</div>