package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
public class Child extends Model {

    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Parent parent;

    @NotNull
    public String name;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

    public String toString() {
        return "Child [id=" + id + ", parent.id=" + parent.id + ", name="
                + name + ", createDate=" + createDate + ", updateDate="
                + updateDate + "]";
    }
}