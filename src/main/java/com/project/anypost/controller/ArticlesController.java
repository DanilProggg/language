package com.project.anypost.controller;

import com.project.anypost.domain.Article;
import com.project.anypost.excaption.NotFoundException;
import com.project.anypost.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("articles")
public class ArticlesController {
    @Autowired
    ArticlesService articlesService;
    @GetMapping("all")
    public Iterable<Article> getAll(){
        return articlesService.getAllService();
    }


    @GetMapping("{id}")
    public ResponseEntity getOneArticle(@RequestParam Long id) throws NotFoundException{
        try{
            return ResponseEntity.ok(articlesService.getOneArticleService(id));
        }catch (NotFoundException e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("create")
    public ResponseEntity createArticle(@RequestBody Article article,
                                        @RequestParam Long userId) throws Exception{
       try{
           return ResponseEntity.ok(articlesService.createArticleService(article,userId));
       } catch (Exception e){
           return ResponseEntity.badRequest().body("Произошла ошибка");
       }
    }
    @PostMapping("update")
    public ResponseEntity updateArticle(@RequestBody Article article){
        try {
            return ResponseEntity.ok(articlesService.updateArticleService(article));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("deleteall")
    public void deleteAll(){
        articlesService.deleteAllService();
    }
}
