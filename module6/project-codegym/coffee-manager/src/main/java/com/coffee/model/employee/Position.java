package com.coffee.model.employee;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Position position = (Position) o;
        return id != null && Objects.equals(id, position.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
