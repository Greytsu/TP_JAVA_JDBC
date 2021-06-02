package models.cours;

public class Cours {
    private int NUM_COURS;
    private String NOM;
    private String NBHEURES;
    private String ANNEE;

    public Cours(int NUM_COURS, String NOM, String NBHEURES, String ANNEE) {
        this.NUM_COURS = NUM_COURS;
        this.NOM = NOM;
        this.NBHEURES = NBHEURES;
        this.ANNEE = ANNEE;
    }

    public int getNUM_COURS() {
        return NUM_COURS;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getNBHEURES() {
        return NBHEURES;
    }

    public void setNBHEURES(String NBHEURES) {
        this.NBHEURES = NBHEURES;
    }

    public String getANNEE() {
        return ANNEE;
    }

    public void setANNEE(String ANNEE) {
        this.ANNEE = ANNEE;
    }
}
