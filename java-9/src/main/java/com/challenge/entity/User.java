package main.java.com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @Column(name="full_name")
    private String fullName;

    @NotBlank
    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    @CreatedDate
    @Column(name="criated_at")
    private Date criatedAt;

    @OneToMany
    private List <Submission> submissions;

    @OneToMany
    private Candidate candidate;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCriatedAt() {
        return this.criatedAt;
    }

    public void setCriatedAt(Date criatedAt) {
        this.criatedAt = criatedAt;
    }

    public List<Submission> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public Candidate getCandidate() {
        return this.candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

}
    
