package LP3.SuperTrunfo;

public abstract class CartaSuperTrunfo {

    private String nome;
    private String identificador;
    private boolean trunfo;

    public CartaSuperTrunfo(String nome, String identificador, boolean trunfo) {
        this.nome = nome;
        this.identificador = identificador;
        this.trunfo = trunfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public boolean isTrunfo() {
        return trunfo;
    }

    public void setTrunfo(boolean trunfo) {
        this.trunfo = trunfo;
    }

    public void printAll(){
        System.out.println("Nome: "+ this.getNome());
        System.out.println("Identificador: " + this.getIdentificador());
        if (this.isTrunfo())
            System.out.println("== CARTA TRUNFO ==");

    }

    public abstract void mostrarListaAtributos();

    public boolean compararTrunfo(CartaSuperTrunfo cartaAdversaria){
        return cartaAdversaria.getIdentificador().indexOf('A') == -1; //retorna true ou false
    }

    public abstract int getAtributo(int atributo);

    public int compararAtributo(CartaSuperTrunfo cartaAdversaria, int atributo){

     ////////////////////////////
        if(atributo == 17){ ///// CÓDIGO DE TRAPAÇA!!!!!!!!!
            return 1;       ///// HACKS
        }                   /////
        if(atributo == 13){ ///// CHEATS !!!!
            return 2;       ///// MANHAS
        }                   /////
    /////////////////////////////

        if (cartaAdversaria.getAtributo(atributo) < this.getAtributo(atributo)){
            return 1;
        }else if(cartaAdversaria.getAtributo(atributo) > this.getAtributo(atributo)){
            return 2;
        }
        return 0;
    }
}