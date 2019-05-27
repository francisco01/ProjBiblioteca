
public class Exemplar {
	public Livro liv;
	public String codexemplar;
	public String Status;
	public Emprestimo emp;
	public Exemplar(Livro liv, String codexemp, String status){
		this.liv = liv;
		this.codexemplar = codexemp;
		this.Status = status;
	}
	public String getCodliv() {
		return liv.getCodigo();
	}
	public String getCodexemplar() {
		return codexemplar;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

}
