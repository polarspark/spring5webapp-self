package com.polarspark.spring5webapp.bootstrap;

import com.polarspark.spring5webapp.model.Author;
import com.polarspark.spring5webapp.model.Book;
import com.polarspark.spring5webapp.model.Publisher;
import com.polarspark.spring5webapp.respositories.AuthorRepository;
import com.polarspark.spring5webapp.respositories.BookRepository;
import com.polarspark.spring5webapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Publisher pub1 = new Publisher("Harper Collins","123 Cat Street NY, NY");
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234");

        eric.getBooks().add(ddd);
        ddd.setPublisher(pub1);
        ddd.getAuthors().add(eric);

        publisherRepository.save(pub1);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Publisher pub2 = new Publisher("Wrox" ,"Becky's Porn World");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        noEJB.setPublisher(pub2);
        rod.getBooks().add(noEJB);

        publisherRepository.save(pub2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }


}
