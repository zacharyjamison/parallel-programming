package com.programming.parallel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dummy {
    List<Posts> posts;
    List<Comments> comments;
    List<Albums> albums;
    List<Photos> photos;
    List<Todos> todos;
    List<Users> users;
}
