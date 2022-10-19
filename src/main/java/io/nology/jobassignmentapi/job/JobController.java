package io.nology.jobassignmentapi.job;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;
    
    @GetMapping
    public ResponseEntity<List<Job>> all(){
        List<Job> allJobs = this.jobService.all();
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> create(@RequestBody JobCreateDTO dto) {
        Job createdJob = this.jobService.create(dto);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
    
        Optional<Job> foundJob = this.jobService.findById(id);
        if(foundJob.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundJob.get(), HttpStatus.OK);
    }
    
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findByTempAssiged(@RequestParam(value="assigned", required = false) boolean tempAssigned){
        System.out.println(tempAssigned);
            Optional<List<Job>> jobsWithTemps = this.jobService.findByTempValue(tempAssigned);
            return new ResponseEntity<>(jobsWithTemps.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Job> updateEmployee(@PathVariable Long id, @RequestBody JobUpdateDTO data){
        Optional<Job> updatedJob = this.jobService.updateJob(data, id);
    if(updatedJob.isEmpty()){
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<>(updatedJob.get(), HttpStatus.OK);
    }

}
