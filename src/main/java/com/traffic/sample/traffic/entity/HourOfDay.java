package com.traffic.sample.traffic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class HourOfDay {

    @Id
    @GeneratedValue
    private Long id;
    private Integer duration;
    @Min(0)
    @Max(23)
    private Integer hourOfDay;

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