package ar.com.ada.sb.security.jwt.model.entity.security;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
// @NoArgsConstructor
@Entity(name = "Authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private AuthorityName name;

    public  Authority(){
        AuthorityName.ROLE_ADMIN.name();
    }
    @ManyToMany(mappedBy = "authorities")

    private List<User> users;

    public Authority setId(Long id) {
        this.id = id;
        return this;
    }

    public Authority setName(AuthorityName name) {
        this.name = name;
        return this;
    }
}



