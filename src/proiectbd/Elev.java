
package proiectbd;

public class Elev {
    
    private int nr_e;
    private String nume_e;
    private String prenume_e;
    private String init_t;
    private int nr_sc;
    
    public Elev(int enr,String enume,String epren,String einit,int escnr ){
        this.nr_e= enr;
        this.nume_e=enume;
        this.prenume_e=epren;
        this.init_t=einit;
        this.nr_sc=escnr;
    }
    
    public int getEnr(){
        return nr_e;}
    public String getNumee(){
        return nume_e;}
    public String getPrene(){
        return prenume_e;}
    public String getInit()
    { return init_t;}
    public int getScnr(){
        return nr_sc;
    }
    
}



  
   
 