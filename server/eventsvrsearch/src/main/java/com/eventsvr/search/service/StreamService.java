package com.eventsvr.search.service;


import com.eventsvr.search.stream.Stream;
import com.eventsvr.search.stream.StreamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StreamService {
    Page<Stream> find(String name, Pageable pageable);

    Page<Stream> find(StreamType streamType, Pageable pageable);
}
