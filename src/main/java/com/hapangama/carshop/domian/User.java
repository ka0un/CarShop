package com.hapangama.carshop.domian;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Role role;
}
