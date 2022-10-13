package io.nology.jobassignmentapi.job;

import java.util.Date;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import io.nology.jobassignmentapi.temp.Temp;

public class JobCreateDTO {
    
    @NonNull
    private String name;

    @NonNull
    private Date startDate;

    @NonNull
    Date endDate;

    // Temp temp;

    @Nullable
    private Long temp;

    public JobCreateDTO(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
       // this.temp = temp;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long tempId) {
        this.temp = tempId;
    }

    

    // public Temp getTemp() {
    //     return temp;
    // }

    // public void setTemp(Temp temp) {
    //     this.temp = temp;
    // }

}
