package io.nology.jobassignmentapi.temp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @OneToMany(mappedBy = "temp" /*, cascade = CascadeType.ALL*/)
    private List<Job> jobs = new ArrayList<>();

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
