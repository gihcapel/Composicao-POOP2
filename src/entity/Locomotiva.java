package entity;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe para trabalhar com locomotivas
 */
public class Locomotiva {

    //Componentes da classe locomotiva
    private Long id;
    private String classe, descricao, pesoMaxRebocavel, pesoMaxLoc, bitolaLoc, comprimentoLoc;

    //Obt�m Id
    public Long getId() {
        return id;
    }

    //Insere Id
    public void setId(Long id) {
        this.id = id;
    }

    //Obt�m classe
    public String getClasse() {
        return classe;
    }

    //Insere classe
    public void setClasse(String classe) {
        this.classe = classe;
    }

    //Obt�m descri��o
    public String getDescricao() {
        return descricao;
    }

    //Insere descri��o
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Obt�m peso m�ximo reboc�vel
    public String getPesoMaxRebocavel() {
        return pesoMaxRebocavel;
    }

    //Insere peso m�ximo reboc�vel
    public void setPesoMaxRebocavel(String pesoMaxRebocavel) {
        this.pesoMaxRebocavel = pesoMaxRebocavel;
    }

    //Obt�m peso m�ximo da locomotiva
    public String getPesoMaxLoc() {
        return pesoMaxLoc;
    }

    //Insere peso m�ximo da locomotiva
    public void setPesoMaxLoc(String pesoMaxLoc) {
        this.pesoMaxLoc = pesoMaxLoc;
    }

    //Obt�m bitola da locomotiva
    public String getBitolaLoc() {
        return bitolaLoc;
    }

    //Insere bitola da locomotiva
    public void setBitolaLoc(String bitolaLoc) {
        this.bitolaLoc = bitolaLoc;
    }

    //Obt�m comprimento
    public String getComprimentoLoc() {
        return comprimentoLoc;
    }

    //Insere comprimento
    public void setComprimentoLoc(String comprimentoLoc) {
        this.comprimentoLoc = comprimentoLoc;
    }

    //Construtor vazio e n�o parametrizado
    public Locomotiva() {
    }

}