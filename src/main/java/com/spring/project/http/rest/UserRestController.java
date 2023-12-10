package com.spring.project.http.rest;

import com.spring.project.dto.PageResponse;
import com.spring.project.dto.UserCreateEditDto;
import com.spring.project.dto.UserReadDto;
import com.spring.project.service.UserService;
import com.spring.project.validation.group.CreateAction;
import com.spring.project.validation.group.UpdateAction;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public PageResponse<UserReadDto> findAll(Pageable pageable) {
        Page<UserReadDto> page = userService.findAll(pageable);
        return PageResponse.of(page);
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@Validated({Default.class, CreateAction.class}) @RequestBody UserCreateEditDto user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable Long id,
                              @Validated({Default.class, UpdateAction.class}) @RequestBody UserCreateEditDto user) {
        return userService.update(id, user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
