package finaltest.model;


import org.hibernate.validator.constraints.NotEmpty;


public class EmpParam {
    private long id;
    
    @NotEmpty
    private String title;
    
    public EmpParam(){}
    public EmpParam(long id, String title) {
        this.id = id;
        this.title = title;
    }
    public long getId(){return id;}
    public void setId(long id) {this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}
}
