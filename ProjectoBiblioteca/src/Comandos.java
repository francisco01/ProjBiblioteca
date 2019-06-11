
public abstract class Comandos {
	
	public String codliv;
	public String codusu;
	
	public String getCodliv(String codigo) {
		return codliv = codigo.substring(4, 7);
	}
	public void setCodliv(String codliv) {
		this.codliv = codliv;
	}
	public String getCodusu(String codigo) {
		return codusu = codigo.substring(0, 3);
	}
	public void setCodusu(String codusu) {
		this.codusu = codusu;
	}
	
	

}
