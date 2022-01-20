package finaltest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employment")
public class EmpEntity implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name="title")
    private String title;
    
    public EmpEntity(){}
    public EmpEntity(long id, String title) {
        this.id = id;
        this.title = title;
        
    }
    public long getId(){return id;}
    public void setId(long id) { this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
}
