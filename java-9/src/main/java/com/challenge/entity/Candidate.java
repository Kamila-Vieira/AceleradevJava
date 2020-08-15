package main.java.com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Candidate {

    @EmbeddedId
    private CandidateId candidateId;
    
    @NotBlank
    @NotNull
    private int status;

    @NotBlank
    @NotNull
    @CreatedDate
    @Column(name="criate_at")
    private Date criatedAt;
    

    public CandidateId getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(CandidateId candidateId) {
        this.candidateId = candidateId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCriatedAt() {
        return this.criatedAt;
    }

    public void setCriatedAt(Date criatedAt) {
        this.criatedAt = criatedAt;
    }

}