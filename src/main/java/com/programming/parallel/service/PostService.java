package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Comments;
import com.programming.parallel.dto.Posts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Service
@Slf4j
public class PostService {
    @Autowired
    DummyClient dummyClient;

    public List<Posts> getPosts()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("PostService");
            return dummyClient.getPosts();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Posts>> getMonoPosts() {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("PostService");
            return dummyClient.getPosts();
        }).subscribeOn(Schedulers.boundedElastic());
    }

}
