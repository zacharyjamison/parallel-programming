package com.programming.parallel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todos {
    private int userId;
    private int id;
    private String title;
    private String completed;
}
