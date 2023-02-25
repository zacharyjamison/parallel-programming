package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Comments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CommentService {
    @Autowired
    DummyClient dummyClient;

    public List<Comments> getComments()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("CommentService");
            return dummyClient.getComments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Comments>> getMonoComments() {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("CommentService");
            return dummyClient.getComments();
        }).subscribeOn(Schedulers.boundedElastic());
    }

}
