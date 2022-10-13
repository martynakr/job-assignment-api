package io.nology.jobassignmentapi.temp;

import org.springframework.lang.NonNull;

public class TempCreateDTO {
    @NonNull
    String firstName;

    @NonNull
    String lastName;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    

}
