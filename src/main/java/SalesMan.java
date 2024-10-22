
public class SalesMan {
    private int sid;
    private String name;
    private String vorname;

    public SalesMan(int sid, String name,String vname) {
        this.sid = sid;
        this.name = name;
        this.vorname = vname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
