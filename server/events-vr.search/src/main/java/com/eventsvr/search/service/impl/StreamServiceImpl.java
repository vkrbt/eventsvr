package com.eventsvr.search.service.impl;

import com.eventsvr.search.repository.StreamRepository;
import com.eventsvr.search.service.StreamService;
import com.eventsvr.search.stream.Stream;
import com.eventsvr.search.stream.StreamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StreamServiceImpl implements StreamService {
    private StreamRepository streamRepository;

    @Override
    public Page<Stream> find(String name, Pageable pageable) {
        return streamRepository.findByNameIgnoreCaseContainingOrderByViewersCount(pageable, name);
    }

    @Override
    public Page<Stream> find(StreamType streamType, Pageable pageable) {
        return streamRepository.findByStreamTypeOrderByViewersCount(pageable, streamType);
    }

    @Autowired
    public void setStreamRepository(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }
}
