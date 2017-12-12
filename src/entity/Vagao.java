package entity;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe para trabalhar com vagões
 */
public class Vagao {

    //Componentes da classe vagão
    String tipo, subtipo, bitola, proprietario;
    private Long id;
    private String pesoMax;
    String comprimento;
    String bitolaMetro;

    //Obtém Id
    public Long getId() {
        return id;
    }

    //Insere Id
    public void setId(Long id) {
        this.id = id;
    }

    //Método que lista todos os tipos de vagões que podem existir
    public enum ListaTipos {
        G, P, T, F, I, H, A, C;
    }

    //Obtém subtipo
    public String getSubtipo() {
        return subtipo;
    }

    //Insere o subtipo
    public void setSubtipo(String subtipo) {
        /*for(ListaTipos lt : ListaTipos.values()){
				if(lt.equals(ListaTipos.G)){
		            if(subtipo=="D" || subtipo=="P" || subtipo=="F" || subtipo=="M" || subtipo=="T" || subtipo=="S" || subtipo=="H" || subtipo=="C" || subtipo=="B" || subtipo=="N" || subtipo=="Q") {
					this.subtipo = subtipo;	
		            }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	        }
		        }else if(lt.equals(ListaTipos.P)){
		        	 if(subtipo=="M" || subtipo=="E" || subtipo=="D" || subtipo=="C" || subtipo=="R" || subtipo=="T" || subtipo=="G" || subtipo=="P" || subtipo=="B" || subtipo=="A" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.T)){
		        	 if(subtipo=="C" || subtipo=="S" || subtipo=="P" || subtipo=="F" || subtipo=="A" || subtipo=="G" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.F)){
		        	 if(subtipo=="R" || subtipo=="S" || subtipo=="M" || subtipo=="E" || subtipo=="H" || subtipo=="L" || subtipo=="P" || subtipo=="V" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.I)){
		        	 if(subtipo=="C" || subtipo=="F" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.H)){
		        	 if(subtipo=="F" || subtipo=="P" || subtipo=="E" || subtipo=="T" || subtipo=="A" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.A)){
		        	 if(subtipo=="C" || subtipo=="M" || subtipo=="R" || subtipo=="V" || subtipo=="D" || subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
			 	        	throw new RuntimeException("Subtipo errado");
			 	     }
		        }else if(lt.equals(ListaTipos.C)){
		        	 if(subtipo=="C" || subtipo=="B"|| subtipo=="N" || subtipo=="Q") {
		 				this.subtipo = subtipo;	
		 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	         }
		        }	
			}*/
        this.subtipo = subtipo;
    }

    //Obtém o tipo
    public String getTipo() {
        return tipo;
    }

    //Insere o tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Obtém a bitola
    public String getBitola() {
        return bitola;
    }

    //Insere a bitola
    public void setBitola(String bitola) {
        this.bitola = bitola;
    }

    //Obtém peso máximo
    public String getPesoMax() {
        return pesoMax;
    }

    //Insere peso máximo
    public void setPesoMax(String pesoMax) {
        this.pesoMax = pesoMax;
    }

    //Obtém tamanho da bitola
    public String getBitolaMetro() {
        return bitolaMetro;
    }

    //Insere tamanho da bitola
    public void setBitolaMetro(String bitolaMetro) {
        this.bitolaMetro = bitolaMetro;
    }

    //Obtém comprimento
    public String getComprimento() {
        return comprimento;
    }

    //Insere comprimento
    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    //Obtém proprietário
    public String getProprietario() {
        return proprietario;
    }

    //Insere proprietário
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    //Imprime componentes da classe
    @Override
    public String toString() {
        return "Vagao [tipo=" + tipo + ", subtipo=" + subtipo + ", bitola=" + bitola + ", proprietario="
                + proprietario + ", id=" + id + ", pesoMax=" + pesoMax + ", bitolaMetro=" + bitolaMetro
                + ", comprimento=" + comprimento + "]";
    }

    //Construtor vazio e não parametrizado
    public Vagao() {
    }

}
