package com.forum.excpetions;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException() {
        super("Article not found!");
    }
}
