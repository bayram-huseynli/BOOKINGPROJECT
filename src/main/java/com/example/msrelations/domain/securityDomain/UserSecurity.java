package com.example.msrelations.domain.securityDomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSecurity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    private String name;

    private LocalDate creationDate;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String mobilePassword;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_authorities",
    joinColumns={@JoinColumn(name = "user_id",referencedColumnName = "id")},
    inverseJoinColumns={@JoinColumn(name = "authority_id",referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();



}
