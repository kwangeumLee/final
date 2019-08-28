package lsis.pal.assign.finalApp;

import java.util.Objects;

public class PalMember {
    private long id;
    private String name;
    private long gender;
    private String description;

    public PalMember() {
    }

    public PalMember(long id, String name, long gender, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
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
        return "PalMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                '}';
    }
}

