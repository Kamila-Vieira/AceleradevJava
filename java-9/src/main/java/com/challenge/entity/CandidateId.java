package main.java.com.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Embeddable
public class CandidateId implements Serializable{
   
    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Acceleration acceleration;

    @NotNull
    @ManyToOne
    private Company company;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CandidateId)) {
            return false;
        }
        CandidateId candidateId = (CandidateId) o;
        return Objects.equals(user, candidateId.user) && Objects.equals(acceleration, candidateId.acceleration) && Objects.equals(company, candidateId.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, acceleration, company);
    }


}