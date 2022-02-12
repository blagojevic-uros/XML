package model.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;
    @Override
    public String getAuthority() {
        return name;
    }
}
