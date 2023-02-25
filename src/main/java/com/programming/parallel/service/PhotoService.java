package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Comments;
import com.programming.parallel.dto.Photos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Service
@Slf4j
public class PhotoService {
    @Autowired
    DummyClient dummyClient;


    public List<Photos> getPhotos()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("PhotoService");
            return dummyClient.getPhotos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Photos>> getMonoPhotos() {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("PhotoService");
            return dummyClient.getPhotos();
        }).subscribeOn(Schedulers.boundedElastic());
    }


}
