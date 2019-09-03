package com.polarspark.spring5webapp.respositories;

import com.polarspark.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
