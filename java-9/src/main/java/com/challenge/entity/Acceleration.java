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
public class Acceleration{

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

    @ManyToOne
    @Column(name="challenge_id")
    private Challenge challenge;
    
    @NotBlank
    @NotNull
    @CreatedDate
    @Column(name="criate_at")
    private Date criatedAt;

    @OneToMany
    List <Candidate> candidate;


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

    public Challenge getChallenge() {
        return this.challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Date getCriatedAt() {
        return this.criatedAt;
    }

    public void setCriatedAt(Date criatedAt) {
        this.criatedAt = criatedAt;
    }

    public List<Candidate> getCandidate() {
        return this.candidate;
    }

    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }
    

}