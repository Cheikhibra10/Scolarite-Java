package com.ecole221;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
       try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le libellé");
        String libelle = scanner.nextLine();
    
        FiliereService filiereService = new FiliereService();
            if (!filiereService.findFiliereByLibelle(libelle)) {
                filiereService.addFiliere(libelle);
                System.out.println(libelle+ " est crée avec succès!");
            } else {
                System.out.println(libelle+ " existe déjà!");
            }
       } catch (Exception e) {
        System.out.println(e);
       }
}
}
