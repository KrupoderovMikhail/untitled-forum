package com.krupoderov.github.untitledforum.controller;

import com.krupoderov.github.untitledforum.model.Discussion;
import com.krupoderov.github.untitledforum.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    DiscussionRepository repository;

    @RequestMapping("/blog")
    public String bloggers(Model model) {
        model.addAttribute("discussions", repository.findAll());
        return "blog";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteDiscussion(@PathVariable("id") Long discussionId) {
        repository.deleteById(discussionId);
        return "redirect:../blog";
    }

    @RequestMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("discussion", new Discussion());
        return "newpost";
    }

    @PostMapping("/save")
    public String save(Discussion discussion) {
        repository.save(discussion);
        return "redirect:..blog";
    }
}
