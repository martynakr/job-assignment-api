package io.nology.jobassignmentapi.job;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
    @Query(value = "SELECT * FROM jobs WHERE temp_id IS NOT NULL",  nativeQuery = true)
    public Optional<List<Job>> findJobsTempsNotNull();

    @Query(value = "SELECT * FROM jobs WHERE temp_id IS NULL", nativeQuery = true)
    public Optional<List<Job>> findJobsTempsNull();
}
