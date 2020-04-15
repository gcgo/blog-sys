package com.gcgo.controller;

import com.gcgo.pojo.Article;
import com.gcgo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articles", articleList);
        return "client/index";
    }
}
