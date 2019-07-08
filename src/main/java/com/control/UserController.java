package com.control;


import com.dozer.entity.UsersDozer;
import com.model.entity.User;
import com.service.entity.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Component
@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String list(@RequestParam("row") String row, @RequestParam("page") String page, @RequestParam("filter") String filter, @RequestParam("order") String order, @RequestParam("orderType") String orderType) {
        System.out.println("*********** list : " + row + "-" + page + "-" + filter + "-" + order + "-" + orderType);
        return "list1";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> list() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/save")
    public User save(@Valid @RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PutMapping(value = "/edit")
    //@ResponseBody -> because use @RestController
    public UsersDozer edit(@Valid @RequestBody User user) {
        userService.edit(user);
        UsersDozer dozer = mapper.map(user, UsersDozer.class);
        return dozer;
    }
}
