var editRoomModal = document.getElementById("editRoomModal");
editRoomModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var newRoomId = button.getAttribute("data-bs-roomId");
    var newRoomName = button.getAttribute("data-bs-roomName");
    var newPhone = button.getAttribute("data-bs-phone");
    var newPayment = button.getAttribute("data-bs-payment");
    var newNote = button.getAttribute("data-bs-note");

    var modalBodyInputNewRoomId = editRoomModal.querySelector("#newRoomId");
    var modalBodyInputNewRoomName = editRoomModal.querySelector("#newRoomName");
    var modalBodyInputNewPhone = editRoomModal.querySelector("#newPhone");
    var modalBodyInputNewPayment = editRoomModal.querySelector("#newPayment");
    var modalBodyInputNewNote = editRoomModal.querySelector("#newNote");

    modalBodyInputNewRoomId.value = newRoomId;
    modalBodyInputNewRoomName.value = newRoomName;
    modalBodyInputNewPhone.value = newPhone;
    modalBodyInputNewPayment.value = newPayment;
    modalBodyInputNewNote.value = newNote;
});

var delRoomModal = document.getElementById("delRoomModal");
delRoomModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var roomId = button.getAttribute("data-bs-roomId");

    var modalBodyInputRoomId = delRoomModal.querySelector("#roomId");

    modalBodyInputRoomId.value = roomId;
});