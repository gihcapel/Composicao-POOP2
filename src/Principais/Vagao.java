package Principais;
public class Vagao {
	String tipo;
	private char subtipo, bitola;
	private double pesoMax, bitolaMetro, comprimento;
	private String proprietario;
	public enum ListaTipos {
	       G, P, T, F, I, H, A, C;
	} 
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		for(ListaTipos lt : ListaTipos.values()){
			if(lt.toString().equals(tipo)){
	            this.tipo = tipo;
	        }else {
	        	throw new RuntimeException("Tipo inválido");
	        }
		}
	}
	public char getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(char subtipo) {
		for(ListaTipos lt : ListaTipos.values()){
			if(lt.equals(ListaTipos.G)){
	            if(subtipo=='D' || subtipo=='P' || subtipo=='F' || subtipo=='M' || subtipo=='T' || subtipo=='S' || subtipo=='H' || subtipo=='C' || subtipo=='B' || subtipo=='N' || subtipo=='Q') {
				this.subtipo = subtipo;	
	            }else {
	 	        	throw new RuntimeException("Subtipo errado");
	 	        }
	        }else if(lt.equals(ListaTipos.P)){
	        	 if(subtipo=='M' || subtipo=='E' || subtipo=='D' || subtipo=='C' || subtipo=='R' || subtipo=='T' || subtipo=='G' || subtipo=='P' || subtipo=='B' || subtipo=='A' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.T)){
	        	 if(subtipo=='C' || subtipo=='S' || subtipo=='P' || subtipo=='F' || subtipo=='A' || subtipo=='G' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.F)){
	        	 if(subtipo=='R' || subtipo=='S' || subtipo=='M' || subtipo=='E' || subtipo=='H' || subtipo=='L' || subtipo=='P' || subtipo=='V' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.I)){
	        	 if(subtipo=='C' || subtipo=='F' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.H)){
	        	 if(subtipo=='F' || subtipo=='P' || subtipo=='E' || subtipo=='T' || subtipo=='A' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.A)){
	        	 if(subtipo=='C' || subtipo=='M' || subtipo=='R' || subtipo=='V' || subtipo=='D' || subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
		 	        	throw new RuntimeException("Subtipo errado");
		 	     }
	        }else if(lt.equals(ListaTipos.C)){
	        	 if(subtipo=='C' || subtipo=='B'|| subtipo=='N' || subtipo=='Q') {
	 				this.subtipo = subtipo;	
	 	         }else {
	 	        	throw new RuntimeException("Subtipo errado");
	 	         }
	        }	
		}
	}
	public char getBitola() {
		return bitola;
	}
	public void setBitola(char bitola) {
		this.bitola = bitola;
	}
	public double getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(double pesoMax) {
		this.pesoMax= pesoMax;
	}

	public double getBitolaMetro() {
		return bitolaMetro;
	}
	public void setBitolaMetro(double bitolaMetro) {
		this.bitolaMetro = bitolaMetro;
	}

	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public Vagao(String tipo, char subtipo, char bitola, double comprimento, String proprietario) {
		this.setTipo(tipo);
		this.setSubtipo(subtipo);
		this.setBitola(bitola);
		this.setComprimento(comprimento);
		this.setProprietario(proprietario);
		if (bitola=='A') {
			setPesoMax(30);
		}
		else if (bitola=='B' || bitola=='P') {
			setPesoMax(47);
		}
		else if (bitola=='C' || bitola=='Q') {
			setPesoMax(64);
		}
		else if (bitola=='D' || bitola=='R') {
			setPesoMax(80);
		}
		else if (bitola=='E' || bitola=='S') {
			setPesoMax(100);
		}
		else if (bitola=='F' || bitola=='T') {
			setPesoMax(119);
		}
		else if (bitola=='G' || bitola=='U') {
			setPesoMax(143);
		}
		if (bitola=='A' || bitola=='B' || bitola=='C' || bitola=='D' || bitola=='E' || bitola=='F'
				|| bitola=='G'  ) {
			setBitolaMetro(1);
		}
		else {
			setBitolaMetro(1.6);
		}
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	@Override
	public String toString() {
		return "Vagao [tipo=" + tipo + ", subtipo=" + subtipo + ", bitola=" + bitola + ", pesoMax=" + pesoMax
				+ ", bitolaMetro=" + bitolaMetro + ", comprimento=" + comprimento + ", proprietario=" + proprietario
				+ "]";
	}
}

