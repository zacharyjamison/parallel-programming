package com.programming.parallel.client;

import com.programming.parallel.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "dummyPosts", url = "https://jsonplaceholder.typicode.com/")
public interface DummyClient {

    @RequestMapping(method = RequestMethod.GET, value="/posts")
    List<Posts> getPosts();

    @RequestMapping(method = RequestMethod.GET, value="/comments")
    List<Comments> getComments();

    @RequestMapping(method = RequestMethod.GET, value="/albums")
    List<Albums> getAlbums();

    @RequestMapping(method = RequestMethod.GET, value="/photos")
    List<Photos> getPhotos();

    @RequestMapping(method = RequestMethod.GET, value="/todos")
    List<Todos> getTodos();

    @RequestMapping(method = RequestMethod.GET, value="/users")
    List<Users> getUsers();

}
