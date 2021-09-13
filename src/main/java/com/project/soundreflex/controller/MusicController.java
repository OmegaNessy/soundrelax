package com.project.soundreflex.controller;

import com.project.soundreflex.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MusicController {
    @Autowired
    private StreamingService service;

    @GetMapping(value = "music/{title}", produces = "audio/mpeg")
    public Mono<Resource> getAudio(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getAudio(title);
    }


}
