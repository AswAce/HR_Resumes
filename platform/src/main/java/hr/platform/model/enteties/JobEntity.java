package hr.platform.model.enteties;

import hr.platform.model.enteties.enums.RemotelyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class JobEntity extends BaseEntity {
    @Column(nullable = false)
    private String title;
    private LocalDate startDate;
    private String type;
    //full time part time
    @Enumerated(EnumType.STRING)
    private RemotelyEnum remote;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    private boolean active;

    @OneToMany
    private Set<UserEntity> users;


}
