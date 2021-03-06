package DMCmodels.model;

import DMCmodels.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "user")
@Getter
@Setter
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    @OneToMany
    private List<AuthorityModel> authorityModels;


    public UserModel(String username, String password, List<AuthorityModel> authorityModels) {
        this.username = username;
        this.password = password;
        this.authorityModels = authorityModels;
    }

    public UserModel(UserDto dto) {
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.authorityModels = dto.getAuthorityModels();
    }

    public UserModel() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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