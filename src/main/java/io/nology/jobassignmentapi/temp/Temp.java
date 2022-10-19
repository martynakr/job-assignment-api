package io.nology.jobassignmentapi.temp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;

import io.nology.jobassignmentapi.job.Job;

@Entity
@Table(name="temps")

public class Temp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tempId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnoreProperties("temp")
    @OneToMany(mappedBy = "temp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Job> jobs;

    public Temp(){}

    public Temp(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getTempId() {
        return tempId;
    }
}
