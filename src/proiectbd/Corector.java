package proiectbd;

public class Corector {
    
    private int nr_c;
    private String nume_c;
    private String prenume_c;
    private String disciplina;
    

public Corector(int cnr, String cnume, String cprenume,String cdisciplina){
    this.nr_c=cnr;
    this.nume_c=cnume;
    this.prenume_c=cprenume;
    this.disciplina=cdisciplina;}

    

public int getCnr(){
    return nr_c;
}

public String getNumec(){
    return nume_c;
}

public String getPrenc(){
    return prenume_c;
}

public String getDisc()
{return disciplina;}
}


