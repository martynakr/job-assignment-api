package io.nology.jobassignmentapi.temp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TempRepository extends JpaRepository<Temp, Long> {

      @Query(value = "SELECT * FROM temps WHERE jobs IS NULL", nativeQuery = true)
      public List<Temp> findTempsForJob(LocalDate jobDate);
    
}
