package ro.tru916.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cata on 27.04.2017.
 */
@Entity
@Table(name = "Conference")
public class Conference extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false, unique = true)
    private Date date;


    @OneToMany(mappedBy = "paper")
    private Set<Paper> papers = new HashSet<>();


    @OneToMany(mappedBy = "reviewer")
    private Set<User> reviewers = new HashSet<>();


    @OneToMany(mappedBy = "speaker")
    private Set<User> speakers = new HashSet<>();

    @OneToMany(mappedBy = "accepted")
    private Set<Paper> acceptedpapers = new HashSet<>();

    public Conference() {
    }

    public Conference(String name, Date date) {
        this.name = name;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public Set<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<User> reviewers) {
        this.reviewers = reviewers;
    }

    public Set<User> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<User> speakers) {
        this.speakers = speakers;
    }

    public Set<Paper> getAcceptedpapers() {
        return acceptedpapers;
    }

    public void setAcceptedpapers(Set<Paper> acceptedpapers) {
        this.acceptedpapers = acceptedpapers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conference that = (Conference) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (papers != null ? !papers.equals(that.papers) : that.papers != null) return false;
        if (reviewers != null ? !reviewers.equals(that.reviewers) : that.reviewers != null) return false;
        if (speakers != null ? !speakers.equals(that.speakers) : that.speakers != null) return false;
        return acceptedpapers != null ? acceptedpapers.equals(that.acceptedpapers) : that.acceptedpapers == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (papers != null ? papers.hashCode() : 0);
        result = 31 * result + (reviewers != null ? reviewers.hashCode() : 0);
        result = 31 * result + (speakers != null ? speakers.hashCode() : 0);
        result = 31 * result + (acceptedpapers != null ? acceptedpapers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", papers=" + papers +
                ", reviewers=" + reviewers +
                ", speakers=" + speakers +
                ", acceptedpapers=" + acceptedpapers +
                '}';
    }
}