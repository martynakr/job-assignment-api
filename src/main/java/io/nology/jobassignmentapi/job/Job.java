package io.nology.jobassignmentapi.job;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.nology.jobassignmentapi.temp.Temp;


@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @ManyToOne
    //(cascade = CascadeType.ALL)
    // @Cascade(CascadeType.SAVE_UPDATE) 
    @JoinColumn(name="temp_id", referencedColumnName = "tempId")
    private Temp temp;

    public Job(){};
    
    public Job(String name, Date startDate, Date endDate ) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        //this.temp = temp;
    }
        public Job(String name, Date startDate, Date endDate, Temp temp ) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.temp = temp;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
   public Temp getTemp() {
        return temp;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setTemp(Temp temp) {
        this.temp = temp;
    }
    
}
