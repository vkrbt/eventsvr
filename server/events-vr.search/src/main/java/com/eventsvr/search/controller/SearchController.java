package com.eventsvr.search.controller;

import com.eventsvr.search.service.StreamService;
import com.eventsvr.search.stream.Stream;
import com.eventsvr.search.stream.StreamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {
    private StreamService streamService;

    @RequestMapping(value = "/autocomplete", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Page<Stream>> autoComplete(@RequestParam String name,
                                             @RequestParam int page,
                                             @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);

        Page<Stream> resultPage = streamService.find(name, pageable);

        return new ResponseEntity<>(new PageImpl<>(resultPage.getContent(), pageable, resultPage.getTotalElements()), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Page<Stream>> search(@RequestParam StreamType streamType,
                                               @RequestParam int page,
                                               @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Stream> resultPage = streamService.find(streamType, pageable);
        return new ResponseEntity<>(new PageImpl<>(resultPage.getContent(), pageable, resultPage.getTotalElements()), HttpStatus.OK);
    }

    @Autowired
    public void setSearchService(StreamService streamService) {
        this.streamService = streamService;
    }
}
