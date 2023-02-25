package com.programming.parallel.service;

import com.programming.parallel.client.DummyClient;
import com.programming.parallel.dto.Todos;
import com.programming.parallel.dto.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserService {
    @Autowired
    DummyClient dummyClient;

    public List<Users> getUsers()  {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("UserService");
            return dummyClient.getUsers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Mono<List<Users>> getMonoUsers() {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            log.info("UserService");
            return dummyClient.getUsers();
        }).subscribeOn(Schedulers.boundedElastic());
    }

}
