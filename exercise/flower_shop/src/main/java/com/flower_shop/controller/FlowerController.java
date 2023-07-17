package com.flower_shop.controller;

import com.flower_shop.dto.FlowerDto;
import com.flower_shop.model.Flower;
import com.flower_shop.service.itf.IFlowerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/flower")
public class FlowerController {
    @Value("${upload}")
    private String fileUpload;

    @Value("${static-image}")
    private String fileDisplay;


    private IFlowerService flowerService;

    public FlowerController(IFlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @ModelAttribute("flowerDto")
    public FlowerDto getFlowerDto() {
        return new FlowerDto();
    }

    @GetMapping("/shop")
    public String goShop(@RequestParam Optional<Integer> page,
                         @RequestParam Optional<String> flowerName,
                         @CookieValue(value = "flowerId", required = false, defaultValue = "-1") String flowerId,
                         Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        Page<Flower> flowerPage = flowerService.findAllPage(
                pageable, "%" + flowerName.orElse("") + "%");
        Flower historyFlower = flowerService.findById(flowerId);

        model.addAttribute("flowerName", flowerName.orElse(""));
        model.addAttribute("flowerPage", flowerPage);
        model.addAttribute("historyFlower", historyFlower);
        return "flower/list";
    }

    @PostMapping("/shop/add")
    public String createProduct(@ModelAttribute FlowerDto flowerDto,
                                RedirectAttributes redirectAttributes) throws IOException {
        List<Flower> flowerList = flowerService.findAllList();
        int maxId = 0;
        if (flowerList.size() == 0) {
            maxId = 1;
        } else {
            for (Flower flower : flowerList) {
                int id = Integer.parseInt(flower.getFlowerId().substring(2));
                if (id + 1 > maxId) {
                    maxId = id + 1;
                }
            }
        }

        String flowerId;
        if (maxId < 10) {
            flowerId = "F-000" + maxId;
        } else if (maxId < 100) {
            flowerId = "F-00" + maxId;
        } else if (maxId < 1000) {
            flowerId = "F-0" + maxId;
        } else {
            flowerId = "F-" + maxId;
        }

        MultipartFile flowerImage = flowerDto.getImage();
        String fileName = flowerImage.getOriginalFilename();
        FileCopyUtils.copy(flowerImage.getBytes(), new File(fileUpload + fileName));
        String imageStr = fileDisplay + fileName;

        Flower flower = new Flower(
                flowerId,
                flowerDto.getFlowerName(),
                flowerDto.getPrice(),
                flowerDto.getQuantity(),
                flowerDto.getDescription(),
                imageStr
        );
        flowerService.addOne(flower);
        redirectAttributes.addFlashAttribute("msg", "Add new successful!");
        return "redirect:/flower/shop";
    }

    @GetMapping("/shop/detail/{id}")
    public String showDetail(@PathVariable String id, HttpServletResponse response,
                             Model model) {
        Cookie cookie = new Cookie("flowerId", id + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        Flower flower = flowerService.findById(id);
        model.addAttribute("flower", flower);
        return "flower/detail";
    }


    @ExceptionHandler(IOException.class)
    public String ioException() {
        return "flower/ioException";
    }

}
