package com.dev.contentcalendar.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {


    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String desc() {
        return desc;
    }

    @Override
    public Status status() {
        return status;
    }

    @Override
    public Type contentType() {
        return contentType;
    }

    @Override
    public LocalDateTime dateCreated() {
        return dateCreated;
    }

    @Override
    public LocalDateTime dateUpdated() {
        return dateUpdated;
    }

    @Override
    public String url() {
        return url;
    }
}
