package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.UserDAO;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

	private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list() {
        return userDAO.findAll();
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public User get(Principal principal) {
        return userDAO.findByUsername(principal.getName());
    }
	
}
