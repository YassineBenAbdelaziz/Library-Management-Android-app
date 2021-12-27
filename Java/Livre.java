/*
Book entity class
Each book identified by an ID and has a title.
*/


package com.example.project;

public class Livre {

    private  int id ;
    private  String titre ;

    public Livre(int id,String titre) {
        this.id = id;
        this.titre = titre ;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
