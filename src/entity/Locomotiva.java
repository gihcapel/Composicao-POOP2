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

    //Obtém Id
    public Long getId() {
        return id;
    }

    //Insere Id
    public void setId(Long id) {
        this.id = id;
    }

    //Obtém classe
    public String getClasse() {
        return classe;
    }

    //Insere classe
    public void setClasse(String classe) {
        this.classe = classe;
    }

    //Obtém descrição
    public String getDescricao() {
        return descricao;
    }

    //Insere descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Obtém peso máximo rebocável
    public String getPesoMaxRebocavel() {
        return pesoMaxRebocavel;
    }

    //Insere peso máximo rebocável
    public void setPesoMaxRebocavel(String pesoMaxRebocavel) {
        this.pesoMaxRebocavel = pesoMaxRebocavel;
    }

    //Obtém peso máximo da locomotiva
    public String getPesoMaxLoc() {
        return pesoMaxLoc;
    }

    //Insere peso máximo da locomotiva
    public void setPesoMaxLoc(String pesoMaxLoc) {
        this.pesoMaxLoc = pesoMaxLoc;
    }

    //Obtém bitola da locomotiva
    public String getBitolaLoc() {
        return bitolaLoc;
    }

    //Insere bitola da locomotiva
    public void setBitolaLoc(String bitolaLoc) {
        this.bitolaLoc = bitolaLoc;
    }

    //Obtém comprimento
    public String getComprimentoLoc() {
        return comprimentoLoc;
    }

    //Insere comprimento
    public void setComprimentoLoc(String comprimentoLoc) {
        this.comprimentoLoc = comprimentoLoc;
    }

    //Construtor vazio e não parametrizado
    public Locomotiva() {
    }

}