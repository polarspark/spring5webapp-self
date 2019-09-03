package com.polarspark.spring5webapp.respositories;

import com.polarspark.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
