package com.myblog.myblog22.payload;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String name;

    private String username;

    private String email;

    private String password;

    private String roleType;
}
