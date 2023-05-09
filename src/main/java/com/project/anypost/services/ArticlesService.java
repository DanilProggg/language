package com.project.anypost.services;


import com.project.anypost.domain.Article;
import com.project.anypost.domain.User;
import com.project.anypost.repos.ArticlesRepo;
import com.project.anypost.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    ArticlesRepo articlesRepo;
    @Autowired
    UsersRepo usersRepo;

    public Iterable<Article> getAllService(){
        Iterable<Article> articles = articlesRepo.findAll();
        return articles;
    }

    public Optional<Article> getOneArticleService(Long id){
        return articlesRepo.findById(id);
    }

    public Article createArticleService(Article article,Long userId){
        User user = usersRepo.findById(userId).get();
        article.setUser(user);
        return articlesRepo.save(article);
    }
    public Article updateArticleService(Article upadtedArticle){
        Article article = articlesRepo.findById(upadtedArticle.getId()).get();
        article.setContent(upadtedArticle.getContent());
        article.setDescription(upadtedArticle.getDescription());
        article.setTitle(upadtedArticle.getTitle());
        return articlesRepo.save(article);
    }

    public void deleteAllService(){
        articlesRepo.deleteAll();
    }
}
 /*
        fetch(
                  '/articles/create',
                  {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ title: 'DOTA', description:'hello. its my first app', content:'Congratulation!!' })
                  }
                ).then(result => result.json().then(console.log))
         */