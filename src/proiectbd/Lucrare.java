
package proiectbd;


public class Lucrare {
     private int nr_l;
    private String disciplina;
    private String data;
    private float nota;
    private int nr_e;
    private int nr_c;
    
     public Lucrare(int lnr,String ldisciplina, String ldata, float lnota, int lenr,int lcnr ){
        this.nr_l= lnr;
        this.disciplina=ldisciplina;
        this.data=ldata;
        this.nota=lnota;
        this.nr_e=lenr;
        this.nr_c=lcnr;
    }
     
     public int getLnr(){
        return nr_l;}
     public String getLdisciplina(){
        return disciplina;}
    public float getLnota(){
        return nota;}
    public String getLdata(){
        return data;}
    public int getLnre(){
        return nr_e;}
    public int getLnrc(){
        return nr_c;
    }
    
}
