package com.gcgo.controller;

import com.gcgo.pojo.Article;
import com.gcgo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        System.out.println("============================");
        Page<Article> articleList=articleService.findArticleList(pageNum, pageSize);
        System.out.println("总页数" + articleList.getTotalPages());
        System.out.println("当前页是：" + pageNum);

        System.out.println("分页数据：");
        for (Article article : articleList) {
            System.out.println(article.toString());
        }
        model.addAttribute("articles", articleList);

        return "index";
    }
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articles", articleList);
        return "index";
    }
}
