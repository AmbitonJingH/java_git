package Model;
/*
*
* UNO
UNAME
UDEPT
UCLASS
USERNAME
UPASSWORD
ID*/
//alter table table_name auto_increment=1;更改自增序列号从1开始
public class User {
    private int uno;
    private String uname;
    private String udept;
    private String uclass;
    private String username;
    private String upassword;
    private String id;
    private int qnum = 0;

    public User() {

    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUdept() {
        return udept;
    }

    public void setUdept(String udept) {
        this.udept = udept;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQnum() {
        return qnum;
    }

    public void setQnum(int qnum) {
        this.qnum = qnum;
    }

    public String toString(){
        return "name:"+uname+"udept:"+udept+"uclass:"+uclass+"username:"+username+"password:"+upassword+"id:"+id+"qnum:"+qnum;
    }
}
