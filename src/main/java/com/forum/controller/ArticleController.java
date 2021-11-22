package com.forum.controller;

import com.forum.entities.Article;
import com.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(this.articleService.createArticle(article), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> readArticleById(@PathVariable Long id) {
        return new ResponseEntity<>(this.articleService.readArticleById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Iterable<Article>> getAllUsers() {
        return new ResponseEntity<>(this.articleService.getAllArticles(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        this.articleService.deleteArticleById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
