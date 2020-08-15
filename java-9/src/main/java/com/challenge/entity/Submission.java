package main.java.com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Submission {

    @EmbeddedId
    private SubmissionId submissionId;
   
    @NotBlank
    @NotNull
    private float score;
    
    @NotBlank
    @NotNull
    @CreatedDate
    @Column(name="criate_at")
    private Date criatedAt;


    public SubmissionId getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(SubmissionId submissionId) {
        this.submissionId = submissionId;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Date getCriatedAt() {
        return this.criatedAt;
    }

    public void setCriatedAt(Date criatedAt) {
        this.criatedAt = criatedAt;
    }


    
}