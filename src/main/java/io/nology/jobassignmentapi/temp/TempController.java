package io.nology.jobassignmentapi.temp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/temps")
public class TempController {

    @Autowired
    private TempService service;

    @GetMapping
    public ResponseEntity<List<Temp>> getAllTemps() {
        List<Temp> allTemps = this.service.all();
        return new ResponseEntity<>(allTemps, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Temp> createTemp(@Valid @RequestBody TempCreateDTO data) {
        Temp createdTemp = this.service.create(data);
        return new ResponseEntity<>(createdTemp, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Temp> findById(@PathVariable Long id){
        Optional<Temp> foundTemp = this.service.findById(id);

        if(foundTemp.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTemp.get(), HttpStatus.OK);
    }

    @GetMapping("/temps")
    public ResponseEntity<List<Temp>> findTempsForJob(@RequestParam (value="jobId") Long id){
        List<Temp> temps = this.service.getTempsAvailForJob(id);

        if(temps.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(temps, HttpStatus.OK);
    }
}
