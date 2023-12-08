package com.spring.project.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
@Value
public class PageResponse<T> {
    List<T> content;
    MetaData metaData;

    public static <T> PageResponse<T> of(Page<T> page){
        var metaDate = new MetaData(page.getNumber(),page.getSize(), page.getTotalElements());
       return new PageResponse<>(page.getContent(),metaDate);
    }
    @Value
    public static class MetaData{
        int page;
        int size;
        long totalElements;
    }
}
