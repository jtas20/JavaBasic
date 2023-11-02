package encapsulamanto;

public class ControleRemoto implements Controlador {
    //ATRÍBUTOS
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //MÉTODOS ESPECIAIS
    public ControleRemoto(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }
    
    private int getVolume(){
        return volume;
    }
    
    private void setVolume(int volume){
        this.volume = volume;
    }
    
    private boolean getLigado(){
        return this.ligado;
    }
    
    private void setLigado(boolean ligado){
        this.ligado = ligado;
    }
    
    private boolean getTocando(){
        return this.tocando;
    }
    
    private void setTocando(boolean tocando){
        this.tocando = tocando;
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("-------------------------");
        System.out.println("          Menu           ");
        System.out.println("-------------------------");
        
        System.out.println("Está Ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());
        for (int i = 1; i <= this.getVolume(); i+=10){
            System.out.print("|");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if(this.getLigado()){
            this.setVolume(this.getVolume() + 10);
        }else{
            System.out.println("Impossivel! Tv Desligada.");
        }
    }

    @Override
    public void menosVolume() {
        if(this.getLigado()){
           this.setVolume(this.getVolume() - 10);
        }else{
            System.out.println("Impossivel! Tv Desligada.");
        }
    }

    @Override
    public void ligarMudo() {
        if(this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
       if(this.getLigado() && !(this.getTocando())){
           this.setTocando(true);
       }
    }

    @Override
    public void pause() {
        if(this.getLigado() && this.getTocando() == true){
            this.setTocando(false);
        }
    }
}