package com.forum.backend.services;

import com.forum.backend.entities.Article;
import com.forum.backend.excpetions.ArticleNotFoundException;
import com.forum.backend.repositories.ArticleRepository;
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

    public Iterable<Article> getAllArticles() {
        return this.articleRepository.findAll();
    }

    public void deleteArticleById(Long id) {
        this.articleRepository.deleteById(id);
    }

}
