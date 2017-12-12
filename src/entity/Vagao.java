package entity;

public class Vagao {


		String tipo, subtipo, bitola, proprietario;
		private Long id;
		public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
		private String pesoMax;
		String comprimento;
		String bitolaMetro;
		public enum ListaTipos {
		       G, P, T, F, I, H, A, C;
		} 
		
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
			this.subtipo=subtipo;
		}
		
		
		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getBitola() {
			return bitola;
		}

		public void setBitola(String bitola) {
			this.bitola = bitola;
		}

		public String getPesoMax() {
			return pesoMax;
		}

		public void setPesoMax(String pesoMax) {
			this.pesoMax = pesoMax;
		}

		public String getBitolaMetro() {
			return bitolaMetro;
		}

		public void setBitolaMetro(String bitolaMetro) {
			this.bitolaMetro = bitolaMetro;
		}

		public String getComprimento() {
			return comprimento;
		}

		public void setComprimento(String comprimento) {
			this.comprimento = comprimento;
		}

		public String getSubtipo() {
			return subtipo;
		}

	
		public Vagao() {
		}
		public String getProprietario() {
			return proprietario;
		}
		public void setProprietario(String proprietario) {
			this.proprietario = proprietario;
		}
		@Override
		public String toString() {
			return "Vagao [tipo=" + tipo + ", subtipo=" + subtipo + ", bitola=" + bitola + ", proprietario="
					+ proprietario + ", id=" + id + ", pesoMax=" + pesoMax + ", bitolaMetro=" + bitolaMetro
					+ ", comprimento=" + comprimento + "]";
		}
		
	
    
}
