
package proiectbd;


public class Examen {
    private int nr_e;
    private String nume_e;
    private String init_t;
    private String prenume_e;
    private float nota_romana;
    private float nota_matematica;
    
      public Examen(int exnre,String exnume,String exinit,String expren,float exnotar,float exnotam ){
        this.nr_e= exnre;
        this.nume_e=exnume;
        this.prenume_e=expren;
        this.init_t=exinit;
        this.nota_romana=exnotar;
        this.nota_matematica=exnotam;
    }
    
    public int getEnr(){
        return nr_e;}
    public String getNumee(){
        return nume_e;}
    public String getPrene(){
        return prenume_e;}
    public String getInit()
    { return init_t;}
    public float getNotaR(){
        return nota_romana;
    }
    public float getNotaM(){
        return nota_matematica;
    }
}
