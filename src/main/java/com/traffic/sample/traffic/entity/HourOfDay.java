package com.traffic.sample.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HourOfDay {

    @Id
    @GeneratedValue
    private Long id;
    private Integer duration;
    private Integer hourOfDay;

    public HourOfDay() {
    }

    public HourOfDay(final Integer duration, final Integer hourOfDay) {
        this.duration = duration;
        this.hourOfDay = hourOfDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(final Integer hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(final Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "HourOfDay{" +
                "id=" + id +
                ", duration=" + duration +
                ", hourOfDay=" + hourOfDay +
                '}';
    }
}