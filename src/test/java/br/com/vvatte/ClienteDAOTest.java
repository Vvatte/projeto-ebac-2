package br.com.vvatte;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.vvatte.dao.ClienteDAO;
import br.com.vvatte.dao.IClienteDAO;
import br.com.vvatte.domain.Cliente;
import br.com.vvatte.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;

	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12345678910L);
		cliente.setNome("Vinicius");
		cliente.setCidade("Sapiranga");
		cliente.setEnd("End");
		cliente.setEstado("RS");
		cliente.setNumero(73);
		cliente.setTel(51999999999L);
		clienteDao.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setCpf(10987654321L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Vinicius Vatte");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Vinicius Vatte", cliente.getNome());
	}
	
	@Test
	public void buscarTodos() {
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
