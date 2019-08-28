package lsis.pal.assign.finalApp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name ="pal_members")
class PalMember {

    @Id
    private Long id;
    private String name;
    private Long gender;
    private String description;

    public PalMember() {
    }

    public PalMember(Long id, String name, Long gender, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalMember palMember = (PalMember) o;
        return id == palMember.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "pal_members{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                '}';
    }
}

