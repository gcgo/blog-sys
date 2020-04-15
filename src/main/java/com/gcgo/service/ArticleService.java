package com.gcgo.service;

import com.gcgo.pojo.Article;
import com.gcgo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        List<Article> all = articleRepository.findAll();
        return all;
    }
}
