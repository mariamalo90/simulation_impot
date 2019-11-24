package com.simulation.impots.simulation_impot;

public class Salaire {
    private double salaireBrut;
    private double part;
    private double impotSurRevenu;
    private int trimf;
    private double salaireNet;
    public void salaire(double salaireBrut){
        this.salaireBrut = salaireBrut;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public double getPart() {
        return part;
    }

    public void setPart(double part) {
        this.part = part;
    }

    public double getImpotSurRevenu() {
        return impotSurRevenu;
    }

    public void setImpotSurRevenu(double impotSurRevenu) {
        this.impotSurRevenu = impotSurRevenu;
    }

    public int getTrimf() {
        return trimf;
    }

    public void setTrimf(int trimf) {
        this.trimf = trimf;
    }

    public double getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(double salaireNet) {
        this.salaireNet = salaireNet;
    }
}
