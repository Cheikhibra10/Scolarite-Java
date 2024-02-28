package com.ecole221;

import com.ecole221.model.Classe;
import com.ecole221.model.Filiere;
import com.ecole221.service.DBHelper;

import java.sql.ResultSet;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        try {
            
Scanner scanner = new Scanner(System.in);
        String libelle = "";
        while (true) {
            System.out.println("Veuillez saisir le libellé de la classe");
            libelle = scanner.nextLine();
            ClasseService classeService = new ClasseService();
            if (classeService.findClasseByLibelle(libelle) != null) {
                System.out.println("cette classe existe déjà!");
                continue;
            }
            break;
        }   

        System.out.println("Veuillez saisir le code de la classe:");
        String code = scanner.nextLine();

        int frais_inscription = 0;
        do {
            System.out.println("Veuillez saisir les frais d'inscriptions:");
            frais_inscription = scanner.nextInt();
        } while (frais_inscription<1000);

        int mensualite = 0;
        do {
            System.out.println("Veuillez saisir la mensualité:");
            mensualite = scanner.nextInt();
        } while (mensualite<1000);

        int autres_frais = 0;
        do {
            System.out.println("Veuillez saisir les autres frais:");
            autres_frais = scanner.nextInt();
        } while (autres_frais<1000);

        DBHelper db = DBHelper.getInstance();
        String sql = "Select * from filiere";
        ResultSet rs = db.excuteSelect(sql, null);
        Integer filiere_id = 0;
        HashMap<Integer,String> fileHashMap = new HashMap<Integer,String>();

        while (rs.next()) {
        fileHashMap.put(rs.getInt("id"),rs.getString("libelle"));
        }
        rs.close();

        for(Map.Entry<Integer,String> entry : fileHashMap.entrySet()){
            System.out.println(entry.getKey()+"/"+entry.getValue());
        }

        do {
            System.out.println("Veuillez saisir l'id de la filière:");
            filiere_id = scanner.nextInt();
        } while (!fileHashMap.containsKey(filiere_id));
        
       ClasseService classeService = new ClasseService();
       Filiere filiere = new Filiere();
       filiere.setId(filiere_id);
       Classe classe = new Classe(0,libelle,code,frais_inscription,mensualite,autres_frais);
       classe.setFiliere(filiere);
       classeService.addClasse(classe);
       
       System.out.println("La classe a été ajoutee avec succes!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
