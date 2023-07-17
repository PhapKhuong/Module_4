var editStudentModal = document.getElementById("editStudentModal");
editStudentModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var newStudentId = button.getAttribute("data-bs-studentId");
    var newStudentName = button.getAttribute("data-bs-studentName");
    var newGrade = button.getAttribute("data-bs-grade");

    var modalBodyInputNewStudentId = editStudentModal.querySelector("#newStudentId");
    var modalBodyInputNewStudentName = editStudentModal.querySelector("#newStudentName");
    var modalBodyInputNewGrade = editStudentModal.querySelector("#newGrade");

    modalBodyInputNewStudentId.value = newStudentId;
    modalBodyInputNewStudentName.value = newStudentName;
    modalBodyInputNewGrade.value = newGrade;
});