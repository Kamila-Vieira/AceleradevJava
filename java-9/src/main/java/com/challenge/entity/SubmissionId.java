package main.java.com.challenge.entity;

import javax.persistence.*;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class SubmissionId implements Serializable{
   
    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Challenge challenge;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubmissionId)) {
            return false;
        }
        SubmissionId submissionId = (SubmissionId) o;
        return Objects.equals(user, submissionId.user) && Objects.equals(challenge, submissionId.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, challenge);
    }


}