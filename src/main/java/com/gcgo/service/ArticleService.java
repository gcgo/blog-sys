package com.gcgo.service;

import com.gcgo.pojo.Article;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();

    Page<Article> findArticleList(int pageNum, int pageSize);
}
