package com.hapangama.carshop.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails {
    private String username;
    private String password;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(role.name());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
