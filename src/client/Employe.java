package client;

import java.rmi.RemoteException;

public class Employe implements java.io.Serializable  {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String nom;
    private String prenom;
    private String grade;
    private String adr;
    private int num_compte;
    private int sup_hierarchie;


    public Employe(int id, String nom, String prenom, String grade, String adr, int num_compte, int sup_hierarchie) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
        this.adr = adr;
        this.num_compte = num_compte;
        this.sup_hierarchie = sup_hierarchie;
    }

    public Employe() throws RemoteException {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(int num_compte) {
        this.num_compte = num_compte;
    }

    public int getSup_hierarchie() {
        return sup_hierarchie;
    }

    public void setSup_hierarchie(int sup_hierarchie) {
        this.sup_hierarchie = sup_hierarchie;
    }

    @Override
    public String toString() {
        return "employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + ", adr=" + adr
                + ", num_compte=" + num_compte + ", sup_hierarchie=" + sup_hierarchie + "]";
    }


}
