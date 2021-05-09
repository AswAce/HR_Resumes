package hr.platform.repository;

import hr.platform.model.enteties.RoleEntity;

import hr.platform.model.enteties.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRole(RoleEnum patient);
}
