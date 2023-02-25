package com.programming.parallel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
