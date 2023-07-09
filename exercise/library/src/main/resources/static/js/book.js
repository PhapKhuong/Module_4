var editBookModal = document.getElementById("editBookModal");
editBookModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var newBookId = button.getAttribute("data-bs-bookId");
    var newBookName = button.getAttribute("data-bs-bookName");
    var newAuthor = button.getAttribute("data-bs-author");
    var newDescription = button.getAttribute("data-bs-description");
    var newQuantity = button.getAttribute("data-bs-quantity");

    var modalBodyInputNewBookId = editBookModal.querySelector("#newBookId");
    var modalBodyInputNewBookName = editBookModal.querySelector("#newBookName");
    var modalBodyInputNewAuthor = editBookModal.querySelector("#newAuthor");
    var modalBodyInputNewDescription = editBookModal.querySelector("#newDescription");
    var modalBodyInputNewQuantity = editBookModal.querySelector("#newQuantity");

    modalBodyInputNewBookId.value = newBookId;
    modalBodyInputNewBookName.value = newBookName;
    modalBodyInputNewAuthor.value = newAuthor;
    modalBodyInputNewDescription.value = newDescription;
    modalBodyInputNewQuantity.value = newQuantity;
});