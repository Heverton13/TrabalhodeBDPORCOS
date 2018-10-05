 
package models;

/**
 *
 * @author Aluno
 */
public class Suino {
    
    private int id;
    private String nome;
    private String data_nasc;
    private String data_aqui;

    public Suino(int id, String nome, String data_nasc, String data_aqui) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.data_aqui = data_aqui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getData_aqui() {
        return data_aqui;
    }

    public void setData_aqui(String data_aqui) {
        this.data_aqui = data_aqui;
    }
  
}
