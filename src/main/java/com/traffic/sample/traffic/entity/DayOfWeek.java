package com.traffic.sample.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DayOfWeek {

    @Id
    @GeneratedValue
    private Long id;
    private Integer duration;
    private String name;

    public DayOfWeek() {
    }

    public DayOfWeek(final Integer duration, final String name) {
        this.duration = duration;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(final Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "id=" + id +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof DayOfWeek)) return false;
        final DayOfWeek dayOfWeek = (DayOfWeek) o;
        return Objects.equals(id, dayOfWeek.id) &&
                Objects.equals(duration, dayOfWeek.duration) &&
                Objects.equals(name, dayOfWeek.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, name);
    }
}