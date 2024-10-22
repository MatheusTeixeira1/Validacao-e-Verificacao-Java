package br.com.adsts.dao;

import java.util.List;

import br.com.adsts.model.Cliente;
import br.com.adsts.util.IdadeInvalidaException;

/**
 * Classe de negócio para realizar operações sobre os clientes do banco.
 * @author Sandro
 */
public class ClienteDAO {

	private List<Cliente> clientesDoBanco;

	public ClienteDAO(List<Cliente> clientesDoBanco) {
		this.clientesDoBanco = clientesDoBanco;
	}
	
	/**
	 * @return lista com todos os clientes do banco
	 */
	public List<Cliente> getClientesDoBanco() {
		return clientesDoBanco;
	}
	
	/**
	 * Pesquisa cliente a partir do ID.
	 * @param idCliente
	 * @return cliente pesquisado ou null, caso não encontrado
	 */
	public Cliente pesquisaCliente (int idCliente) {
		for (Cliente cliente : clientesDoBanco) {
			if (cliente.getId() == idCliente)
				return cliente;
		}
		return null;
	}
	
	/**
	 * Adiciona novo cliente à lista de clientes do banco.
	 * @param novoCliente cliente a ser adicionado
	 */
	public void adicionaCliente (Cliente novoCliente) {
		clientesDoBanco.add(novoCliente);
	}

	/**
	 * Remove cliente da lista de clientes do banco.
	 * @param idCliente 
	 * @return true se removido ou false, caso contrário.
	 */
	public boolean removeCliente (int idCliente) {
		boolean clienteRemovido = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if (cliente.getId() == idCliente) {
				clientesDoBanco.remove(i);
				clienteRemovido = true;
				break;
			}
		}
		
		return clienteRemovido;
	}

	/**
	 * Informa se cliente está ativo ou não.
	 * @param idCliente
	 * @return true se cliente ativo ou false, caso contrário. 
	 */
	public boolean clienteAtivo(int idCliente) {
		boolean clienteAtivo = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			
			if (cliente.getId() == idCliente)
				if (cliente.isAtivo()) {
					clienteAtivo = true;
					break;
				}
		}
		
		return clienteAtivo;
	}

	/**
	 * Limpa lista de clientes 
	 */
	public void limpa() {
		this.clientesDoBanco.clear();
	}
	
	/**
	 * Valida se idade do cliente está dentro do intervalo permitido (18 - 65).
	 * @param idade a idade do cliente
	 */
	public boolean validaIdade(int idade) throws IdadeInvalidaException {
	
		if (idade < 18 || idade > 65)
			throw new IdadeInvalidaException(IdadeInvalidaException.MSG_IDADE_INVALIDA);
		
		return true;
	}
}
