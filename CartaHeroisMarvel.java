package LP3.SuperTrunfo;

public class CartaHeroisMarvel extends CartaSuperTrunfo {

    private int altura;
    private int inteligencia;
    private int forca;
    private int velocidade;
    private int habilidade;

    public CartaHeroisMarvel(String nome, String identificador, boolean trunfo, int altura, int inteligencia, int forca, int velocidade, int habilidade) {
        super(nome, identificador, trunfo);
        this.altura = altura;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.velocidade = velocidade;
        this.habilidade = habilidade;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public void printAll(){
        super.printAll();
        System.out.println("Altura: " + this.getAltura());
        System.out.println("Inteligência: " + this.getInteligencia());
        System.out.println("Força: " + this.getForca());
        System.out.println("Velocidade: " + this.getVelocidade());
        System.out.println("Habilidade: " + this.getHabilidade());
    }


    @Override
    public void mostrarListaAtributos() {
        System.out.printf("Herói: %s  |  Identificador: %s\n", this.getNome(), this.getIdentificador());
        System.out.printf("1 - Altura: %s\n", this.getAltura());
        System.out.printf("2 - Inteligência: %s\n", this.getInteligencia());
        System.out.printf("3 - Força: %s\n", this.getForca());
        System.out.printf("4 - Velocidade: %s\n", this.getVelocidade());
        System.out.printf("5 - Habilidade: %s\n", this.getHabilidade());
    }

    @Override
    public int getAtributo(int atributo) {
        switch (atributo){
            case 1:
                return this.getAltura();
            case 2:
                return this.getInteligencia();
            case 3:
                return this.getForca();
            case 4:
                return this.getVelocidade();
            default:
                return this.getHabilidade();
        }
    }
}
