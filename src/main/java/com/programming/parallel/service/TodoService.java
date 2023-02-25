package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Todos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TodoService {
    @Autowired
    DummyClient dummyClient;


    public List<Todos> getTodos()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("TodoService");
            return dummyClient.getTodos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Todos>> getMonoTodos() {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("TodoService");
            return dummyClient.getTodos();
        }).subscribeOn(Schedulers.boundedElastic());
    }

}
