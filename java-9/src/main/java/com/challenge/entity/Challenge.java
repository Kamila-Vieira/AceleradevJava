package main.java.com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 100)
    @NotNull
    private String name;

    @NotBlank
    @Size(max = 50)
    @NotNull
    private String slug;

    @NotBlank
    @NotNull
    @CreatedDate
    @Column(name="criate_at")
    private Date criatedAt;

    @OneToMany 
    private List <Submission> submission;
    
    @OneToMany
    private Acceleration acceleration;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getCriatedAt() {
        return this.criatedAt;
    }

    public void setCriatedAt(Date criatedAt) {
        this.criatedAt = criatedAt;
    }

    public List<Submission> getSubmission() {
        return this.submission;
    }

    public void setSubmission(List<Submission> submission) {
        this.submission = submission;
    }

    public Acceleration getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

}