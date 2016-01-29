function updateLogo(input) {
    var reader = new FileReader();
    reader.onload = function (e) {
        $("#image").attr("src", e.target.result);
    };
    reader.readAsDataURL(input.files[0]);
}
