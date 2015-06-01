package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity

public class Parent extends Model {

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
	    public List<Child> children = new ArrayList<Child>();
    @Id
    public Long id;

    @NotNull
    public String name;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

    public String toString() {
        return "Parent [id=" + id + ", name=" + name + ", createDate="
                + createDate + ", updateDate=" + updateDate + "]";
    }
}
