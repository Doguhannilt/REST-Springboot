package com.dev.contentcalendar.repository;

import com.dev.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    // In-memory database simulation
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
        // Optional: Add some initial data
        // Content c = new Content(1, "My First Blog", "I know how", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
        // contentList.add(c);
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    public Content save(Content c) {
        contentList.add(c);
        return c;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    public boolean existsById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }
}
