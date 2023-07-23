showCategory();
showBlogByCategory();

function showCategory() {
    let categoryStr = '<li id="0" onclick="showBlogByCategory(this.id)" class="dropdown-item">All</li>';
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/blogs/category",
        success: function (categories) {
            for (let i = 0; i < categories.length; i++) {
                categoryStr +=
                    `<li id="${categories[i].categoryId}" onclick="showBlogByCategory(this.id)" class="dropdown-item">
                    ${categories[i].categoryName}</li>`;
            }
            $("#category").html(categoryStr);
        }
    })
}

function showBlogByCategory(categoryId) {
    let blogsStr = '';
    let btnStr = '';
    let page = 0;
    let id;
    if (!categoryId) {
        id = 0;
    } else {
        id = categoryId;
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
            if (blogs.category === null) {
                btnStr += `<span content="0" id="cId">All</span>`;

            } else {
                btnStr += `<span content="${categoryId}" id="cId">${blogs.category.categoryName}</span>`;
            }
            $("#dropdownMenuButton1").html(btnStr);
        }
    })
}

function showBlogByPage(step) {
    let blogsStr = '';
    let btnStr = '';
    let e = document.getElementById("cId");
    let id = e.getAttribute("content");
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
            if (blogs.category === null) {
                btnStr += `<span content="0" id="cId">All</span>`;

            } else {
                btnStr += `<span content="${categoryId}" id="cId">${blogs.category.categoryName}</span>`;
            }
            $("#dropdownMenuButton1").html(btnStr);
        }
    })
}

