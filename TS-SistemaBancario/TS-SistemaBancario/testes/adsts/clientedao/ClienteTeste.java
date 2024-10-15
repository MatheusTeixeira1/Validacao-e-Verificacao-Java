package adsts.clientedao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.adsts.dao.ClienteDAO;
import br.com.adsts.model.Cliente;

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

    @Test
    public void testarCriacao() {
        assertNotNull(cDAO);
        assertNotNull(cDAO.pesquisaCliente(1));
        assertEquals("Matheus", cDAO.pesquisaCliente(1).getNome(), "O nome não está correto");
        assertEquals(1, cDAO.pesquisaCliente(1).getId());
        assertEquals("email@gmail.com", cDAO.pesquisaCliente(1).getEmail());
        assertEquals(1, cDAO.pesquisaCliente(1).getIdContaCorrente());
    }

    @Test
    public void testarExclusao() {
        assertNotNull(cDAO);
        assertTrue(cDAO.removeCliente(1));
        assertEquals(1, cDAO.getClientesDoBanco().size());
    }
}
