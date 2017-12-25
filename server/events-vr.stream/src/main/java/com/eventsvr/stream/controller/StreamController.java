package com.eventsvr.stream.controller;


import com.eventsvr.stream.controller.dao.StreamResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StreamController {
    @RequestMapping(value = "/stream", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<StreamResponse> stream(@RequestParam int id,
                                                 @RequestParam int frame) {
        StreamResponse response = new StreamResponse();
        response.setUrl(id, frame);
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
