package kz.g134.FlightTicketsShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseClass implements UserDetails {
    @Column(name="full_name",nullable=false)
    private String fullName;

    @Column(name="username", nullable = false,unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="age")
    private Integer age;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name="user_roles",
              joinColumns=@JoinColumn(name="user_id"),
              inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
