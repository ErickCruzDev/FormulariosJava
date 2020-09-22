package p2_tareagrupal;

public class VelocidadSonido implements VelocidadDelSonido{
    
    @Override
    public double PropaAire(int s){
        return (340*s)/1000;
    }  
    @Override
    public double PropaAgua(int s){
        return(1500*s)/1000 ;
    }
    @Override
    public double PropaMadera(int s){
       return (3700*s)/1000;
    }
    @Override
    public double PropaAcero(int s){
        return(6100*s)/1000;
    }
    @Override
    public double PropaAluminio(int s){
        return(6400*s)/1000;
    }
    @Override
    public double PropaHormigon(int s){
       return(4000*s)/1000;
    }    
}
