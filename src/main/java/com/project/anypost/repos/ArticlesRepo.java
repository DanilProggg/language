package com.project.anypost.repos;

import com.project.anypost.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesRepo extends CrudRepository<Article,Long> {
    List<Article> findByTitle(String title);
}
