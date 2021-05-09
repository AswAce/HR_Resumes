package hr.platform.model.enteties;

import hr.platform.model.enteties.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}