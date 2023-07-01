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
    private String uno;
    private String uname = "";
    private String udept = "";
    private String uclass = "";
    private String username = "";
    private String upassword = "";
    private String id = "";
    private int offnum = 0;
    private String usex;

    public User() {

    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
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

    public int getOffnum() {
        return offnum;
    }

    public void setOffnum(int offnum) {
        this.offnum = offnum;
    }

    public String toString(){
        return String.format("姓名：%s\t系别：%s\t班级：%s\t用户名：%s\t密码：%s\t身份:%s\t发布题目数量:%d\n",uname,udept,uclass,username,upassword,id,offnum);
    }
}
