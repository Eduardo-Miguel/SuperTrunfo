package LP3.SuperTrunfo;

public class CartaCavaleirosZodiaco extends CartaSuperTrunfo{
    private int soco;
    private int chute;
    private int tecnica;
    private int conhecimentos;
    private int forca;

    public CartaCavaleirosZodiaco(String nome, String identificador, boolean trunfo, int soco, int chute, int tecnica, int conhecimentos, int forca) {
        super(nome, identificador, trunfo);
        this.soco = soco;
        this.chute = chute;
        this.tecnica = tecnica;
        this.conhecimentos = conhecimentos;
        this.forca = forca;
    }

    public int getSoco() {
        return soco;
    }

    public void setSoco(int soco) {
        this.soco = soco;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getTecnica() {
        return tecnica;
    }

    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(int conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void printAll(){
        super.printAll();
        System.out.println("Soco: " + this.getSoco());
        System.out.println("Chute: " + this.getChute());
        System.out.println("Técnica: " + this.getTecnica());
        System.out.println("Conhecimentos: " + this.getConhecimentos());
        System.out.println("Força: " + this.getForca());
    }

    @Override
    public void mostrarListaAtributos() {
        System.out.printf("Cavaleiro: %s  |  Identificador: %s\n", this.getNome(), this.getIdentificador());
        System.out.printf("1 - Soco: %s\n", this.getSoco());
        System.out.printf("2 - Chute: %s\n", this.getChute());
        System.out.printf("3 - Técnica: %s\n", this.getTecnica());
        System.out.printf("4 - Conhecimentos: %s\n", this.getConhecimentos());
        System.out.printf("5 - Força: %s\n", this.getForca());
    }

    @Override
    public int getAtributo(int atributo) {
        switch (atributo){
            case 1:
                return this.getSoco();
            case 2:
                return this.getChute();
            case 3:
                return this.getTecnica();
            case 4:
                return this.getConhecimentos();
            default:
                return this.getForca();
        }
    }
}
