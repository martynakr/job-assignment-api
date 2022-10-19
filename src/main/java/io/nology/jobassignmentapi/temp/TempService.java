package io.nology.jobassignmentapi.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.jobassignmentapi.job.Job;
import io.nology.jobassignmentapi.job.JobRepository;

@Service
@Transactional
public class TempService {

    @Autowired
    private TempRepository repository;

    @Autowired
    private JobRepository jobRepository;

    public List<Temp> all() {
        return this.repository.findAll();
    }
    public Temp create(TempCreateDTO data){
        Temp newTemp = new Temp(data.getFirstName(), data.getLastName());
        this.repository.save(newTemp);
        return newTemp;
    }

    public Optional<Temp> findById(Long id) {
        return this.repository.findById(id);
    }

    public List<Temp> getTempsAvailForJob(Long id){
        List<Temp> allTemps = this.repository.findAll();
        List<Temp> tempsForJob = new ArrayList<>();

        Optional<Job> job = this.jobRepository.findById(id);

        // if job with id doesn't exist, throw new error?

        // what to do if the job already has a temp?

        if(!job.isEmpty()) {

            for(Temp temp : allTemps){
                if (temp.getJobs() == null){
                    tempsForJob.add(temp);
                }

                if(temp.getJobs().stream().allMatch(t -> t.getEndDate().isBefore(job.get(). getStartDate()) || t.getStartDate().isAfter(job.get().getEndDate()))){
                tempsForJob.add(temp);
                }
            }
        }

        return tempsForJob;
    }
}
