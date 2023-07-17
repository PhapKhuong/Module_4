var editCardModal = document.getElementById("editCardModal");
editCardModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var cardId = button.getAttribute("data-bs-cardId");

    var modalBodyInputCardId = editCardModal.querySelector("#cardId");

    modalBodyInputCardId.value = cardId;
});