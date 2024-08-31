package com.dev.contentcalendar.controller;


import com.dev.contentcalendar.model.Content;
import com.dev.contentcalendar.repository.ContentCollectionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    // DEPENDENCY INJECTION
    private final ContentCollectionRepository repository;

    // Constructor injection
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    // FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Content> findById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(content -> ResponseEntity.ok(content))
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE
    @PostMapping("")
    public ResponseEntity<Content> create(@RequestBody Content content) {
        Content savedContent = repository.save(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Content> update(@RequestBody Content content, @PathVariable Integer id) {
        if (repository.existsById(id)) {

            Content updatedContent = repository.save(content);
            return ResponseEntity.ok(updatedContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
