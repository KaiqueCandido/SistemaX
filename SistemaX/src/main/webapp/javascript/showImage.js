function updateLogo(input) {
    var reader = new FileReader(this);
    reader.onload = function (e) {
        $("#image").attr("src", e.target.result);
    };
    reader.readAsDataURL(input.files[0]);
}

function previewFile() {
  var preview = document.querySelector('img');
  var file    = document.querySelector('input[type=file]').files[0];
  var reader  = new FileReader();

  reader.onloadend = function () {
    preview.src = reader.result;
  };

  if (file) {
    reader.readAsDataURL(file);
  } else {
    preview.src = "imagens/perfil-face.jpg";
  }
}