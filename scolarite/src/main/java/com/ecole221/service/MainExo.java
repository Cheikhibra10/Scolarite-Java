package com.ecole221.service;

import com.ecole221.ClasseService;
import com.ecole221.model.Classe;

import java.sql.SQLException;
import java.util.List;

public class MainExo {
    public static void main(String[] args) {
        ClasseService classeService = new ClasseService();
        try {
            List<Classe> classes = classeService.findAllClasses();
            classes.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e);;
        }
    }
}



