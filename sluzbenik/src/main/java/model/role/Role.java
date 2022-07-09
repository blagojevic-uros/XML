package model.role;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@XmlRootElement(name = "role")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;
    @Override
    public String getAuthority() {
        return name;
    }
}
