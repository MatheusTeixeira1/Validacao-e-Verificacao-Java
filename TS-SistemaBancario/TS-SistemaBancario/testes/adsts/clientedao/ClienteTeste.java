package adsts.clientedao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.adsts.dao.ClienteDAO;
import br.com.adsts.model.Cliente;
import br.com.adsts.util.IdadeInvalidaException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteTeste {
	private static ClienteDAO cDAO;

    @BeforeAll
    public static void iniciar() {
        Cliente cliente1 = new Cliente(1, "Matheus", 21, "email@gmail.com", 1, true);
        Cliente cliente2 = new Cliente(2, "Sowear", 21, "email@gmail.com", 2, true);
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        cDAO = new ClienteDAO(listaClientes);
    }
    @Order(1)
    @Test
    public void testeCriarDao() {
    	assertNotNull(cDAO);
    }
    
    @Order(2)
    @Test
    public void testeGetClientesDoBanco(){
    	boolean resultado = cDAO.getClientesDoBanco().size()>0;
    	assertTrue("Não existe cliente registrado", resultado);
    	assertNotNull("Tabela de cliente é nula",cDAO.getClientesDoBanco());
    }
    @Order(3)
    @Test
    public void testePesquisaCliente(){
    	assertNotNull(cDAO.pesquisaCliente(1));
        assertEquals("Matheus", cDAO.pesquisaCliente(1).getNome(), "O nome incorreto ou nulo");
        assertEquals(1, cDAO.pesquisaCliente(1).getId(),"O id incorreto ou nulo");
        assertEquals("email@gmail.com", cDAO.pesquisaCliente(1).getEmail(),"O email incorreto ou nulo");
        assertEquals(1, cDAO.pesquisaCliente(1).getIdContaCorrente(),"O id da conta incorreto ou nulo");
    }
    @Order(4)
    @Test
    public void testeAdicionaCliente(){
    	Cliente cliente = new Cliente(3, "Ana", 22, "email@gmail.com", 3, true);
    	cDAO.adicionaCliente(cliente);
    	assertNotNull(cDAO.pesquisaCliente(3));
    	
    }
    @Order(5)
    @Test
    public void testeRemoveCliente() {
    	int tamanhoAntes = cDAO.getClientesDoBanco().size();
        assertTrue(cDAO.removeCliente(1));
        assertEquals(tamanhoAntes-1, cDAO.getClientesDoBanco().size());
        assertNull(cDAO.pesquisaCliente(1));
        Cliente cliente2 = new Cliente(2, "Sowear", 21, "email@gmail.com", 2, true);
        cDAO.adicionaCliente(cliente2);
    }
    
    
 

    
    @Order(6)
    @Test
    public void testeClienteAtivo(){
    	assertTrue(cDAO.clienteAtivo(1));
    }
    @Order(8)
    @Test
    public void testeLimpa(){
    	cDAO.limpa();
    	assertNull(cDAO.getClientesDoBanco());
    }
    @Order(7)
    @Test
    public void testeValidaIdade(){
    	assertThrows(IdadeInvalidaException.class, () -> cDAO.validaIdade(10));
    		
    }
    }
