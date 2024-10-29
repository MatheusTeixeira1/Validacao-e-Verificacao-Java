package model;

public class Lance {
	private Usuario usuario;
	private Double valor;
	
	public Lance() {
		super();
	}
	public Lance(Usuario usuario, Double valor) {
		super();
		this.usuario = usuario;
		this.valor = valor;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
