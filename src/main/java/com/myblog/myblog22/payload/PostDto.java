package com.myblog.myblog22.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    long id;

    private String title;

    private String description;

    private String content;
}
