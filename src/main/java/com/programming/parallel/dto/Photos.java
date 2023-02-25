package com.programming.parallel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Photos {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
