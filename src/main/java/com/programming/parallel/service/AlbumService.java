package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Albums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AlbumService {

    @Autowired
    DummyClient dummyClient;


    public List<Albums> getAlbums()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("AlbumService");
            return dummyClient.getAlbums();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Albums>> getMonoAlbums()  {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("AlbumService");
            return dummyClient.getAlbums();
        }).subscribeOn(Schedulers.boundedElastic());
    }


}
