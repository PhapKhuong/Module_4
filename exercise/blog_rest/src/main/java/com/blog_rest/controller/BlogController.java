package com.blog_rest.controller;

import com.blog_rest.dto.BlogDto;
import com.blog_rest.dto.BlogPageSearch;
import com.blog_rest.model.Blog;
import com.blog_rest.model.Category;
import com.blog_rest.service.itf.IBlogService;
import com.blog_rest.service.itf.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("blogs")
    public List<Blog> getBlogList() {
        return blogService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("blog")
    public Blog getBlog() {
        return new Blog();
    }

    @ModelAttribute("category")
    public Category getCategory() {
        return new Category();
    }

    @GetMapping("/blog")
    public ResponseEntity<?> showBlogPage(
            @RequestParam int page,
            @RequestParam int id) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogPage;
        Category category;
        if (id == 0) {
            blogPage = blogService.findAll(pageable);
            category = null;
        } else {
            blogPage = blogService.findByCategory(pageable, id);
            category = categoryService.findOne(id);
        }
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            BlogPageSearch blogPageSearch =new BlogPageSearch(category, blogPage);
            return new ResponseEntity<>(blogPageSearch, HttpStatus.OK);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

    // DO THÊM MỚI CATEGORY NẰM TRÊN TRANG THÊM MỚI BLOG, NÊN TẠO RA MỘT FORM CÓ 2 NÚT SUBMIT,
    // MỘT NÚT CÓ ACTION "Add new", NẾU BẤM VÀO ĐÂY SẼ CHUYỂN QUA TRANG THÊM MỚI CATEGORY
    // VÀ KÈM THEO BLOG ĐÃ SOẠN ĐỂ KHI THÊM MỚI XONG SẼ KHÔNG CẦN SOẠN LẠI BLOG TRƯỚC ĐÓ NỮA.
    // CÒN NẾU BẤM VÀO NÚT SUBMIT CÒN LẠI THÌ ĐÓ LÀ THÊM MỚI BLOG.
    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestParam String action,
                                    @RequestBody BlogDto blogDto) {
        if (action.equals("Add new")) {
            return new ResponseEntity<>(blogDto, HttpStatus.OK);
        } else {
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto, blog);
            blogService.add(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delBlog(@PathVariable int id) {
        List<Blog> blogs = blogService.findAll();
        List<Integer> ids = new ArrayList<>();
        for (Blog blog : blogs) {
            ids.add(blog.getId());
        }
        if (ids.contains(id)) {
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> initUpdate(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> update(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DO THÊM MỚI CATEGORY NẰM TRÊN TRANG THÊM MỚI BLOG NÊN ĐỂ KHÔNG PHẢI SOẠN LẠI BLOG,
    // PHẢI GỬI KÈM BLOG ĐÃ SOẠN ĐI KÈM VỚI CATEGORY CẦN TẠO.
    @PostMapping("/add-new-category")
    public ResponseEntity<?> createCategory(@RequestBody Category category,
                                            @RequestBody BlogDto blogDto) {
        categoryService.add(category);
        return new ResponseEntity<>(blogDto, HttpStatus.OK);
    }
}
