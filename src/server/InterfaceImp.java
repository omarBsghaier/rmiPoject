package server;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;


public class InterfaceImp extends UnicastRemoteObject implements Interface  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected InterfaceImp() throws RemoteException {
        super();
    }

    Connection conn;
    public void createEmploye(Employe emp ) {

        conn=DBconnection.createConnection();
        String query="insert into employe values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptsm=conn.prepareStatement(query);
            ptsm.setInt(1,emp.getId());
            ptsm.setString(2,emp.getNom());
            ptsm.setString(3,emp.getPrenom());
            ptsm.setString(4,emp.getGrade());
            ptsm.setString(5,emp.getAdr());
            ptsm.setLong(6,emp.getNum_compte());
            ptsm.setInt(7,emp.getSup_hierarchie());
            int k = ptsm.executeUpdate();
            if (k!=0){
                System.out.println("creation de l'employé reussi");
            }

            System.out.println("-------------------------------");

        }catch(Exception e) {
            e.printStackTrace();
        }


    }


    @Override

    public ArrayList<Employe> readEmploye() throws RemoteException {
        ArrayList<Employe> employes = new ArrayList<Employe>();
        conn=DBconnection.createConnection();
        String query="select * from employe";
        //System.setOut(new PrintStream("voila les employés"));
        try {
            Statement st= conn.createStatement();
            ResultSet res=st.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String grade  = res.getString("grade");
                String adresse = res.getString("adresse");
                int num_compte = res.getInt("num_compte");
                int sup_hierarchie = res.getInt("sup_hierarchie");
                Employe employe = new Employe(id ,nom, prenom, grade,adresse, num_compte, sup_hierarchie);
                employes.add(employe);


            }}catch (Exception e) {
            e.printStackTrace();
        }
        return employes;
    }
    public ArrayList<Employe> readOneEmploye(int id_emp) throws RemoteException {
        ArrayList<Employe> employe = new ArrayList<Employe>();
        conn=DBconnection.createConnection();
        String query="select * from employe where id="+id_emp;
        //System.setOut(new PrintStream("voila les employés"));
        try {
            Statement st= conn.createStatement();
            ResultSet res=st.executeQuery(query);
            res.next();
            int id = res.getInt("id");
            String nom = res.getString("nom");
            String prenom = res.getString("prenom");
            String grade  = res.getString("grade");
            String adresse = res.getString("adresse");
            int num_compte = res.getInt("num_compte");
            int sup_hierarchie = res.getInt("sup_hierarchie");
            Employe emp = new Employe(id ,nom, prenom, grade,adresse, num_compte, sup_hierarchie);
            employe.add(emp);

        }catch (Exception e) {
            e.printStackTrace();
        };
        return employe;
    }

    @Override

    public void updateEmploye(int id, String grade) throws RemoteException {
        conn= DBconnection.createConnection();
        String query="update employe set grade=? where id=?";
        try {
            PreparedStatement pstm= conn.prepareStatement(query);
            pstm.setString(1,grade);
            pstm.setInt(2,id);
            int l=pstm.executeUpdate();
            if(l!=0) {
                System.out.println("modification reussie");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override

    public void deleteEmploye(int id) throws RemoteException {
        conn=DBconnection.createConnection();
        String query="delete from employe where id=?";
        try {
            PreparedStatement pstm= conn.prepareStatement(query);
            pstm.setInt(1,id);
            int h=pstm.executeUpdate();
            if (h!=0) {
                System.out.println("employé supprimé");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }




    @Override
    public void createTache(Tache t) throws RemoteException {
        conn=DBconnection.createConnection();
        String query="insert into tache values(?,?,?)";
        try {
            PreparedStatement ptsm=conn.prepareStatement(query);
            ptsm.setInt(1,t.getId());
            ptsm.setString(2,t.getDesc());
            ptsm.setInt(3,t.getId_emp());
            int k = ptsm.executeUpdate();
            if (k!=0){
                System.out.println("creation de la tache reussi");
            }

            System.out.println("-------------------------------");

        }catch(Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public ArrayList<Tache> readTache() throws RemoteException {
        ArrayList<Tache> taches = new ArrayList<Tache>();
        conn=DBconnection.createConnection();
        String query="select * from tache";
        // System.out.println("voila les taches");
        try {
            Statement st= conn.createStatement();
            ResultSet res=st.executeQuery(query);
            while(res.next()){
                int id=res.getInt("id");
                String desc= res.getString("description");
                int id_emp= res.getInt("id_emp");
                Tache tache= new Tache(id,desc,id_emp);
                taches.add(tache);

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
        return taches;
    }
    public ArrayList<Tache> readOneTache(int id_tache) throws RemoteException {
        ArrayList<Tache> tache1 = new ArrayList<Tache>();
        conn=DBconnection.createConnection();
        String query="select * from tache where id="+id_tache;
        try {
            Statement st= conn.createStatement();
            ResultSet res=st.executeQuery(query);
            res.next();
            int id = res.getInt("id");
            String description = res.getString("description");
            int id_emp = res.getInt("id_emp");

            Tache tache = new Tache(id ,description, id_emp);
            tache1.add(tache);

        }catch (Exception e) {
            e.printStackTrace();
        };
        return tache1;
    }


    @Override
    public void updateTache(int id, String desc) throws RemoteException {
        conn=DBconnection.createConnection();
        String query="update tache set description=? where id=?";
        try {
            PreparedStatement pstm= conn.prepareStatement(query);
            pstm.setString(1,desc);
            pstm.setInt(2,id);
            int l=pstm.executeUpdate();
            if(l!=0) {
                System.out.println("modification reussie");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteTache(int id) throws RemoteException {
        conn=DBconnection.createConnection();
        String query="delete from tache where id=?";
        try {
            PreparedStatement pstm= conn.prepareStatement(query);
            pstm.setInt(1,id);
            int h=pstm.executeUpdate();
            if (h!=0) {
                System.out.println("tache supprimée");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void hello(String h) throws RemoteException{
        System.out.println("hello"+ h);
    }


}