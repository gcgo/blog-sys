package com.gcgo.service.Impl;

import com.gcgo.pojo.Article;
import com.gcgo.repository.ArticleRepository;
import com.gcgo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        List<Article> all = articleRepository.findAll();
        return all;
    }

    @Override
    public Page<Article> findArticleList(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Article> all = articleRepository.findAll(pageable);
        return all;
    }
}
