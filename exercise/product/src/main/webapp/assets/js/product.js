var delProductModal = document.getElementById("delProductModal");
delProductModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var delId = button.getAttribute("data-bs-id");

    var modalBodyInputId = delProductModal.querySelector("#delId");

    modalBodyInputId.value = delId;
});


var editProductModal = document.getElementById("editProductModal");
editProductModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var newId = button.getAttribute("data-bs-id");
    var newName = button.getAttribute("data-bs-name");
    var newOrigin = button.getAttribute("data-bs-origin");
    var newPrice = button.getAttribute("data-bs-price");

    var modalBodyInputId = editProductModal.querySelector("#newId");
    var modalBodyInputName = editProductModal.querySelector("#newName");
    var modalBodyInputOrigin = editProductModal.querySelector("#newOrigin");
    var modalBodyInputPrice = editProductModal.querySelector("#newPrice");

    modalBodyInputId.value = newId;
    modalBodyInputName.value = newName;
    modalBodyInputOrigin.value = newOrigin;
    modalBodyInputPrice.value = newPrice;
});