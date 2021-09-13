package com.project.soundreflex.controller;

import com.project.soundreflex.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
public class WhiteNoseController {

    @Autowired
    StreamingService service;

    @GetMapping(value = "nose/{title}", produces = "audio/mpeg")
    public Mono<Resource> getWhiteNose(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getWhiteNose(title);
    }
}
