package com.forum.service;

import com.forum.entities.Article;
import com.forum.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createOrUpdateArticle(Article article) {
        return this.articleRepository.save(article);
    }

    public Optional<Article> readArticleById(Long id) {
        return this.articleRepository.findById(id);
    }

    public void deleteArticleById(Long id) {
        this.articleRepository.deleteById(id);
    }

    public Iterable<Article> getAllArticles() {
        return this.articleRepository.findAll();
    }

}
