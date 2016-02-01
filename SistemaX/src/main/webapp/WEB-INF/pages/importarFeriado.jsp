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
        <div class="dj-text__center carregaImagem margin">        
            
            <button class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect btn-upload">Upload Arquivo CSV</button>            
            <input id="caminhoArquivo" type="file" class="dj-invisible inp-upload" name="caminhoArquivo" onchange="updateLogo(this)"/>
                    
                   
            <div class="botoes-fechar dj-text__right">
                <button type="submit" class="mdl-button mdl-button mdl-button--colored mdl-button--raised" onclick="caminho()">Importar</button>
                <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active dj-invisible" id="loading"></div>
            </div>            

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