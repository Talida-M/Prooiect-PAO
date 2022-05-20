package services;

import models.Opera;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClientServices {
    public Map<String, Opera> getOpere() {
        return opere;
    }

    public void setOpere(Map<String, Opera> opere) {
        this.opere = opere;
    }

    public ClientServices(Map<String, Opera> opere) {
        this.opere = opere;
    }

    private Map<String, Opera> opere = new HashMap<>();

//    public void posteazaOpera(Scanner in) throws ParseException{
//        Opera nouaOpera =
//    }

    public List<Opera>  afisareOpere() throws Exception{
        return List.of();

    }
    void AchizitieOpera(){
        Scanner s = new Scanner(System.in);
        System.out.println("Completati cu codul sau numele operei pe care doriti sa o achizitionati:");
        String opera = s.nextLine();

    }
}
