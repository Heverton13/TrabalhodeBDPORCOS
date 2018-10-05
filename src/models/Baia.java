package models;
/**
 *
 * @author Aluno
 */
public class Baia {
    
    private int id;
    private double tamanho;
    private boolean baiaLimpa;
    private Suino suinos;

    public Baia(int id, double tamanho, boolean baiaLimpa) {
        this.id = id;
        this.tamanho = tamanho;
        this.baiaLimpa = baiaLimpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isBaiaLimpa() {
        return baiaLimpa;
    }

    public void setBaiaLimpa(boolean baiaLimpa) {
        this.baiaLimpa = baiaLimpa;
    }
    
}
