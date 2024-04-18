package br.com.vvatte.services;

import br.com.vvatte.dao.IClienteDAO;
import br.com.vvatte.domain.Cliente;
import br.com.vvatte.services.generic.GenericService;


public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}
}
