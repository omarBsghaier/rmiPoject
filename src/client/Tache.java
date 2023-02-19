package client;
import java.rmi.RemoteException;

public class Tache implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String desc;
    private int id_emp;

    public Tache() throws RemoteException {
        super();
    }

    public int getId() {
        return id;
    }
    public Tache(int id, String desc, int id_emp) {
        super();
        this.id = id;
        this.desc = desc;
        this.id_emp = id_emp;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getId_emp() {
        return id_emp;
    }
    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    @Override
    public String toString() {
        return "tache [id=" + id + ", desc=" + desc + ", id_emp=" + id_emp + "]";
    }

}