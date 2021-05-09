package hr.platform.model.enteties;

import hr.platform.model.enteties.enums.LanguageEnum;
import hr.platform.model.enteties.enums.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String email;
    private String username;
    @Column(nullable = false)
    private String fullName;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;
    @Enumerated(EnumType.STRING)
    private LevelEnum languageLevel;

    private String resume;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles = new ArrayList<>();
}
