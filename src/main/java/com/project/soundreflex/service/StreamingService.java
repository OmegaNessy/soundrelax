package com.project.soundreflex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {
    private static final String FORMAT="classpath:audios/%s.mp3";
    private static final String FORMAT_NOSE="classpath:noses/%s.mp3";


    @Autowired
    private ResourceLoader resourceLoader;


    public Mono<Resource> getAudio(String title){
        return Mono.fromSupplier(()->resourceLoader.
                getResource(String.format(FORMAT,title)))   ;
    }

    public Mono<Resource> getWhiteNose(String title){
        return Mono.fromSupplier(() -> resourceLoader.
                getResource(String.format(FORMAT_NOSE, title)));
    }
}
