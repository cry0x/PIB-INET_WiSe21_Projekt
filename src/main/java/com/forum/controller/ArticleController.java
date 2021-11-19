package com.forum.controller;

import com.forum.entities.Article;
import com.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@ModelAttribute Article article) {
        return ResponseEntity.ok(this.articleService.createArticle(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> readArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(this.articleService.readArticleById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.articleService.deleteArticleById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(this.articleService.getAllArticles());
    }

}
