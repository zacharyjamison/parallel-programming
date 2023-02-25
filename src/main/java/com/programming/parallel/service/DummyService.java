package com.programming.parallel.service;

import com.programming.parallel.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple6;

import java.util.List;

@Service
public class DummyService {

    @Autowired
    AlbumService albumService;

    @Autowired
    CommentService commentService;

    @Autowired
    PhotoService photoService;

    @Autowired
    PostService postService;

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;


    // Should take a minimum of six seconds
    public Dummy getDummy() {
        final long start = System.currentTimeMillis();
        Dummy dummy = new Dummy();
        dummy.setAlbums(albumService.getAlbums());
        dummy.setComments(commentService.getComments());
        dummy.setPhotos(photoService.getPhotos());
        dummy.setPosts(postService.getPosts());
        dummy.setTodos(todoService.getTodos());
        dummy.setUsers(userService.getUsers());
        final long end = System.currentTimeMillis();

        System.out.println("The program was running: " + ((double)(end-start)/1000.0d) + "ms.");

        return dummy;
    }

    public Dummy getMonoDummy() {
        Dummy dummy = new Dummy();

        final long start = System.currentTimeMillis();
        var dummyMonoInfo = callService().block();
        final long end = System.currentTimeMillis();

        System.out.println("The program was running: " + ((double)(end-start)/1000.0d) + "ms.");

        if(null != dummyMonoInfo) {
            dummy.setAlbums(dummyMonoInfo.getAlbums());
            dummy.setComments(dummyMonoInfo.getComments());
            dummy.setPhotos(dummyMonoInfo.getPhotos());
            dummy.setPosts(dummyMonoInfo.getPosts());
            dummy.setTodos(dummyMonoInfo.getTodos());
            dummy.setUsers(dummyMonoInfo.getUsers());

            return dummyMonoInfo;
        }
        return null;
    }

    public Mono<Dummy> callService() {
        var albums = albumService.getMonoAlbums();
        var comments = commentService.getMonoComments();
        var photos = photoService.getMonoPhotos();
        var posts = postService.getMonoPosts();
        var todos = todoService.getMonoTodos();
        var users = userService.getMonoUsers();

        return Mono.zip(albums, comments, photos,posts,todos,users).map(this::setDummyInfo);
    }

    public Dummy setDummyInfo(Tuple6<List<Albums>, List<Comments>,List<Photos>, List<Posts>, List<Todos>,
                                    List<Users>> dummy) {

        Dummy dummyInfo = new Dummy();
        dummyInfo.setAlbums(dummy.getT1());
        dummyInfo.setComments(dummy.getT2());
        dummyInfo.setPhotos(dummy.getT3());
        dummyInfo.setPosts(dummy.getT4());
        dummyInfo.setTodos(dummy.getT5());
        dummyInfo.setUsers(dummy.getT6());

        return dummyInfo;

    }


}
