/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mohamed
 */
public class Etudiant {

    Connection con = null;
    public String nom="11";
    public String prenom;
    public int cin;
    public String groupe;
    public String genre;
    public String login;
    public String mdp;

    public Etudiant() {
        // Etape 1: Chargement driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver charger...");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("erreur chargement. " + e.getMessage());
        }

        // Etape 2: Connexion vers la base
        String url = "jdbc:mysql://127.0.0.1/issat_intranet";
        String user = "root";
        String mp = "";

        try {
            con = DriverManager.getConnection(url, user, mp);
            System.out.println("connexion etablie...");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erreur de connexion. " + e.getMessage());
        }
    }

    public int sauvegarder(int cin, String nom, String prenom, String groupe, int genre, String login, String mdp) {
        int a = 0;
        String rq = "insert into etudiants(cin,nom,prenom,groupe,genre,login,motDePasse) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(rq);
            ps.setInt(1, cin);
            ps.setString(2, nom);
            ps.setString(3, prenom);
            ps.setString(4, groupe);
            ps.setInt(5, genre);
            ps.setString(6, login);
            ps.setString(7, mdp);
            a = ps.executeUpdate();
            System.out.println("insertion avec success...");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erreur d'ajout. " + e.getMessage());
        }
        return a;
    }

    public boolean connexion(String login, String mdp) {
        String rq = "select * from etudiants where login=? and motDePasse=?";
        try {
            PreparedStatement ps = con.prepareStatement(rq);
            ps.setString(1, login);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.nom=rs.getString("nom");
                this.prenom=rs.getString("prenom");
                this.cin=rs.getInt("cin");
                this.login=rs.getString("login");
                this.groupe=rs.getString("groupe");
                if(rs.getInt("genre")==1){
                    this.genre="homme";
                }else{
                    this.genre="femme";
                }
                this.mdp=rs.getString("motDePasse");
            }
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erreur d'ajout. " + e.getMessage());
            return false;
        }

    }
}
