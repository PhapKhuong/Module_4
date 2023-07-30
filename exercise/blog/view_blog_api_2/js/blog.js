showCategory();
showBlogByCategory();

function showCategory() {
    let categoryStr = '<option value="0" class="dropdown-item"/>All';
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/blogs/category",
        success: function (categories) {
            for (let i = 0; i < categories.length; i++) {
                categoryStr +=
                    `<option value="${categories[i].categoryId}" class="dropdown-item"/>
                    ${categories[i].categoryName}`;
            }
            $("#category").html(categoryStr);
        }
    })
}

function showBlogByCategory() {
    let blogsStr = '';
    let page = 0;
    let id;
    if (!$("#category").val()) {
        id = 0;
    } else {
        id = $("#category").val();
    }
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: `http://localhost:8080/blogs/blog?page=0&id=${id}`,
        success: function x(blogs) {
            for (let i = 0; i < blogs.blogPage.content.length; i++) {
                blogsStr +=
                    `<tr class="col">\n
                        <td>${i + 1}</td>\n
                        <td>${blogs.blogPage.content[i].title}</td>\n
                        <td>${blogs.blogPage.content[i].date}</td>\n
                        <td>${blogs.blogPage.content[i].category.categoryName}</td>\\n
                        <td>Detail</td>\n
                        <td>Delete</td>\n
                        <td>Edit</td>\n
                        </tr>\n`
            }
            $("#blogs").html(blogsStr);
            $("#current-page").text(page);
        }
    })
}

function showBlogByPage(step) {
    let blogsStr = '';
    let id = $("#category").val();
    let page;
    if (step === "previous-page") {
        page = +$("#current-page").text() - 1;
    } else {
        page = +$("#current-page").text() + 1;
    }
    console.log(page);
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: `http://localhost:8080/blogs/blog?page=${page}&id=${id}`,
        success: function (blogs) {
            for (let i = 0; i < blogs.blogPage.content.length; i++) {
                blogsStr +=
                    `<tr class="col">\n
                        <td>${i + 1}</td>\n
                        <td>${blogs.blogPage.content[i].title}</td>\n
                        <td>${blogs.blogPage.content[i].date}</td>\n
                        <td>${blogs.blogPage.content[i].category.categoryName}</td>\\n
                        <td>Detail</td>\n
                        <td>Delete</td>\n
                        <td>Edit</td>\n
                        </tr>\n`
            }
            $("#blogs").html(blogsStr);
            $("#current-page").text(page);
        }
    })
}

