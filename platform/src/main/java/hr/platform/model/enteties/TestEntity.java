package hr.platform.model.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test")
public class TestEntity extends BaseEntity {

    private String author;
    private String feed;
    private String gs$cell;

    private String score;
}
