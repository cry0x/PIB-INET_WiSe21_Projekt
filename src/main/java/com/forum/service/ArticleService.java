package com.forum.service;

import com.forum.entities.Article;
import com.forum.excpetions.ArticleNotFoundException;
import com.forum.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(Article article) {
        return this.articleRepository.save(article);
    }

    public Article readArticleById(Long id) {
        return this.articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
    }

    public void deleteArticleById(Long id) {
        this.articleRepository.deleteById(id);
    }

    public Iterable<Article> getAllArticles() {
        return this.articleRepository.findAll();
    }

}
