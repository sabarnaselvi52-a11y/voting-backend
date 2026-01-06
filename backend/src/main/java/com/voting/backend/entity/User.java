package com.voting.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String epic;
    private String password;

    public Long getId() { return id; }

    public String getEpic() { return epic; }
    public void setEpic(String epic) { this.epic = epic; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
