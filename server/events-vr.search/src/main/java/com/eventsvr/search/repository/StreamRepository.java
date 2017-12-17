package com.eventsvr.search.repository;

import com.eventsvr.search.stream.Stream;
import com.eventsvr.search.stream.StreamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends PagingAndSortingRepository<Stream, String> {
    Page<Stream> findByStreamTypeOrderByViewersCount(Pageable pageable, StreamType streamType);

    Page<Stream> findByNameIgnoreCaseContainingOrderByViewersCount(Pageable pageable, String value);
}
