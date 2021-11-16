package com.forum.controller;

import com.forum.entities.Article;
import com.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@ModelAttribute Article article) {
        Optional<Article> newArticle = Optional.of(this.articleService.createOrUpdateArticle(article));

        if (!newArticle.isPresent())
            return ResponseEntity.badRequest().body("The article could not be created.");

        return ResponseEntity.ok(newArticle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readArticleById(@PathVariable Long id) {
        Optional<Article> article = this.articleService.readArticleById(id);

        if (!article.isPresent())
            return ResponseEntity.badRequest().body(String.format("There is no article with the ID: %d", id));

        return ResponseEntity.ok(article);
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