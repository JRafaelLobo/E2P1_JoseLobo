/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e2p1_joselobo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rinal
 */
public class Procesos {

    public ArrayList<String> TransicionesArray;
    public ArrayList<String> Especial;

    public String[] MaquinaEstadosstado(String Estados, String Transiciones, String Computar) {

        String[] temp = new String[3];
        String[] VariosEstados = Estados.split(";");
        String Estado = VariosEstados[0];
        TransicionesArray = splitStr(Transiciones, ';');
        imprimir(TransicionesArray);
        extractAcceptNodes();
        temp[2]="";
        for (int i = 0; i < Computar.length(); i++) {
            String str = Estado + "," + Computar.charAt(i);
            System.out.println(str);
            String validacion = computeStr(str);
            System.out.println("validacion:" + validacion);
            if (validacion != "") {
                String[] test = validacion.split(",");
                temp[0] += Estado + ": " + Computar.charAt(i) + " -> " + test[2] + "\n";
                System.out.println("??" + Estado + "??");
                Estado = test[2];
                System.out.println("??" + Estado + "??");

            } else {
                temp[2] ="Hubo Un Error";
            }
        }
        if ("q2".equals(Estado)) {
            temp[1] = "Aceptada";
        } else {
            temp[1] = "Rechazada";
        }
        return temp;
    }

    public ArrayList<String> splitStr(String str, char delim) {
        ArrayList<String> temp = new ArrayList();
        String[] temp2 = str.split(";");
        for (int i = 0; i < temp2.length; i++) {
            temp.add(temp2[i]);
        }
        //temp.addAll(Arrays.asList(temp2));
        System.out.println("ADDALL");
        imprimir(temp);
        return temp;

    }

    /*public ArrayList<String> splitArray(ArrayList<> str, char delim) {
        ArrayList<String> temp = new ArrayList();
        //String[] temp3 = new String[1];
        String[] temp2 = str.split("delim");
        /* for (int i = 0; i < temp2.length; i++) {
           temp3 = temp2[i].split(";");
        }**
        temp.addAll(Arrays.asList(temp2));
        return temp;

    }*/
    public void extractAcceptNodes() {
        for (int i = 0; i < TransicionesArray.size(); i++) {
            if (TransicionesArray.get(i).contains(".")) {
                String temp = TransicionesArray.get(i);
                Especial.add(temp);
                TransicionesArray.remove(i);
                for (i = 0; i < temp.length(); i++) {
                    String temp2 = "";
                    if (temp.charAt(i) != '.') {
                        temp2 += temp.charAt(i);
                    }
                    temp = temp2;
                }//for i
                TransicionesArray.add(i, temp);
            }
        }
    }

    public String computeStr(String str) {
        for (int i = 0; i < TransicionesArray.size(); i++) {
            if (TransicionesArray.get(i).contains(str)) {
                System.out.println("Return: " + TransicionesArray.get(i));
                return TransicionesArray.get(i);
            }
        }

        return "";
    }

    public void imprimir(ArrayList<String> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print("[[" + a.get(i) + "]]");
        }
        System.out.println();
    }
}
