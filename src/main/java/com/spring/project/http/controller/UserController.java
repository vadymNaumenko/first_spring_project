package com.spring.project.http.controller;

import com.spring.project.database.entity.Role;
import com.spring.project.database.entity.User;
import com.spring.project.dto.PageResponse;
import com.spring.project.dto.UserCreateEditDto;
import com.spring.project.dto.UserReadDto;
import com.spring.project.service.CompanyService;
import com.spring.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    //    @GetMapping
//    public String findAll(Model model, UserFilter filter) {
//        List<UserReadDto> all = userService.findAll(filter);
//        model.addAttribute("users", userService.findAll(filter));
//        return "user/users";
//    }
    @GetMapping
    public String findAll(Model model, Pageable pageable) {
        Page<UserReadDto> page = userService.findAll(pageable);
        PageResponse<UserReadDto> response = PageResponse.of(page);
        model.addAttribute("users", response);
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    // 14 min
    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute UserCreateEditDto user, RedirectAttributes redirectAttributes) {
        if (true) {
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/users/registration";
        }
        return "redirect:/users/" + userService.create(user).getId();
    }

    //    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, @ModelAttribute UserCreateEditDto user) {
        return userService.update(id, user)
                .map(it -> {
                    return "redirect:/users/{id}";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //    @DeleteMapping("/{id}")
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }


}
