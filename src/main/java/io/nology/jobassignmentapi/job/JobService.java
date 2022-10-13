package io.nology.jobassignmentapi.job;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.nology.jobassignmentapi.temp.Temp;
import io.nology.jobassignmentapi.temp.TempRepository;

@Service
@Transactional
public class JobService {
    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TempRepository tempRepository;

    public List<Job> all() {
        return this.jobRepository.findAll();
    }

    public Optional<Job> findById(Long id){
        return this.jobRepository.findById(id);
    }

    public Job create(JobCreateDTO dto){
        
        //, 
        //dto.getTemp()

        if(dto.getTemp() != null) {
            Optional<Temp> temp = this.tempRepository.findById(dto.getTemp());

            if(!temp.isEmpty()){
                 Job newJob = new Job(dto.getName(), dto.getStartDate(), dto.getEndDate(), temp.get());
            this.jobRepository.save(newJob);
            return newJob;
            } else {
                Job newJob = new Job(dto.getName(), dto.getStartDate(), dto.getEndDate());
              this.jobRepository.save(newJob);
            return newJob;

            }

        } else {
            Job newJob = new Job(dto.getName(), dto.getStartDate(), dto.getEndDate());
              this.jobRepository.save(newJob);
            return newJob;
        }

       
        // if(dto.getTemp() != null){
        //     Optional<Temp> savedTemp = this.tempRepository.findById(dto.getTemp());
        //     System.out.println(savedTemp);
        //     if(!savedTemp.isEmpty()){
        //         newJob.setTemp(savedTemp.get());
        //     }
            
        // }
        // if(dto.getTemp() != null){
        //     tempRepository.save(dto.getTemp());
        // }
      
    }

    public Optional<List<Job>> findByTempValue(boolean data){
        if(data == true){
            Optional<List<Job>> jobsWithTemps = this.jobRepository.findJobsTempsNotNull();
            return jobsWithTemps;
        } 
            Optional<List<Job>> jobsWithoutTemps = this.jobRepository.findJobsTempsNull();
            return jobsWithoutTemps;


    }   
}
