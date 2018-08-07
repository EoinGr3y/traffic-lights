package com.traffic.sample.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DayOfWeek {

    @Id
    @GeneratedValue
    private Long id;
    private Integer duration;
    private String name;

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
}