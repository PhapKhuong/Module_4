package com.room.controller;

import com.room.model.Payment;
import com.room.model.Room;
import com.room.model.dto.RoomDto;
import com.room.service.itf.IPaymentService;
import com.room.service.itf.IRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/room")
public class RoomController {
    private IRoomService roomService;
    private IPaymentService paymentService;

    public RoomController(IRoomService roomService,
                          IPaymentService paymentService) {
        this.roomService = roomService;
        this.paymentService = paymentService;
    }

    @ModelAttribute("payments")
    public List<Payment> getPaymentList() {
        return paymentService.findList();
    }

    @ModelAttribute("room")
    public Room getRoom() {
        return new Room();
    }

    @ModelAttribute("roomDto")
    public RoomDto getRoomDto() {
        return new RoomDto();
    }

    @GetMapping("/show-room")
    public String displayRoom(@RequestParam Optional<Integer> page,
                              @RequestParam Optional<String> name,
                              Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        String roomName = "%" + name.orElse("") + "%";
        Page<Room> roomPage = roomService.findPage(pageable, roomName);

        model.addAttribute("roomPage", roomPage);
        model.addAttribute("name", name.orElse(""));
        return "room/room";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Room room = roomService.findOne(id);
        model.addAttribute("room", room);
        return "room/detail";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "room/add";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute RoomDto roomDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        new RoomDto().validate(roomDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "room/add";
        }

        List<Room> rooms = roomService.findList();
        List<Integer> roomIdAsInt = new ArrayList<>();
        for (Room r : rooms) {
            roomIdAsInt.add(Integer.parseInt(r.getRoomId().substring(2)));
        }
        int maxId = 0;
        for (Integer id : roomIdAsInt) {
            if (id + 1 > maxId) {
                maxId = id + 1;
            }
        }
        String roomId;
        if (maxId < 10) {
            roomId = "P-000" + maxId;
        } else if (maxId < 100) {
            roomId = "P-00" + maxId;
        } else if (maxId < 1000) {
            roomId = "P-0" + maxId;
        } else {
            roomId = "P-" + maxId;
        }
        roomDto.setRoomId(roomId);

        Room room = new Room();
        BeanUtils.copyProperties(roomDto, room);

        roomService.create(room);
        redirectAttributes.addFlashAttribute("msg", "Add new success!");
        return "redirect:/room/show-room";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable String id,
                                 Model model) {
        Room updateRoom = roomService.findOne(id);
        RoomDto roomDto = new RoomDto();
        BeanUtils.copyProperties(updateRoom, roomDto);
        model.addAttribute("roomDto", roomDto);
        return "room/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute RoomDto roomDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new RoomDto().validate(roomDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "room/edit";
        }
        Room room = new Room();
        BeanUtils.copyProperties(roomDto, room);
        roomService.update(room);
        redirectAttributes.addFlashAttribute("msg", "Update success!");
        return "redirect:/room/show-room";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Room room,
                         RedirectAttributes redirectAttributes) {
        Room delRoom = roomService.findOne(room.getRoomId());
        roomService.delete(delRoom);
        redirectAttributes.addFlashAttribute("msg", "Delete success!");
        return "redirect:/room/show-room";
    }

    @PostMapping("/confirm")
    public String confirmDel(@RequestParam("choose") String[] choose,
                             RedirectAttributes redirectAttributes) {
        int option = JOptionPane.showConfirmDialog(null,
                "Are you sure?", "Delete selected records", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            for (String roomId : choose) {
                Room delRoom = roomService.findOne(roomId);
                roomService.delete(delRoom);
            }
            redirectAttributes.addFlashAttribute("msg", "Delete success!");
        }
        return "redirect:/room/show-room";
    }
}
