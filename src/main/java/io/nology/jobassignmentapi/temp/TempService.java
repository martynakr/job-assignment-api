package io.nology.jobassignmentapi.temp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempService {

    @Autowired
    private TempRepository repository;

    public List<Temp> all() {
        return this.repository.findAll();
    }
    public Temp create(TempCreateDTO data){
        // prevent duplicate employee
        Temp newTemp = new Temp(data.getFirstName(), data.getLastName());

        this.repository.save(newTemp);
        System.out.println(newTemp.getTempId());
        return newTemp;
    }
}
