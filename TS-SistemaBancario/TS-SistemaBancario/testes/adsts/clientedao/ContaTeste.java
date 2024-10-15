package adsts.clientedao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.adsts.dao.ContaCorrenteDAO;
import br.com.adsts.model.ContaCorrente;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContaTeste {
	private static ContaCorrenteDAO cDAO;

    @BeforeAll
    public static void iniciar() {
        ContaCorrente conta1 = new ContaCorrente(1, 1000.0, true);
        ContaCorrente conta2 = new ContaCorrente(2, 640.0, true);
        List<ContaCorrente> listaContas = new ArrayList<>();
        listaContas.add(conta1);
        listaContas.add(conta2);
        cDAO = new ContaCorrenteDAO(listaContas);
    }
    
    @Test
    @Order(1)
    public void testeCriarDao(){
    	assertNotNull(cDAO);
    }
    
    @Test
    @Order(2)
    public void testeGetContasBanco(){
    	List<ContaCorrente> listaContas = new ArrayList<>();
    	listaContas = cDAO.getContasDoBanco();
    	boolean existeCliente = listaContas.size()>0;
    	
    	ContaCorrente contaModelo = new ContaCorrente(1, 1000.0, true);
    	ContaCorrente contaPesquisada = listaContas.get(0);
    	
    	assertNotNull(listaContas);
    	assertTrue(existeCliente);
    	assertEquals(contaModelo.getId(), contaPesquisada.getId(),"ID incorreto ou nulo");
    	assertNotNull("ID nulo", contaPesquisada.getId());
    	assertEquals(contaModelo.getSaldo(), contaPesquisada.getSaldo(), "SALDO incorreto ou nulo");
    	assertNotNull("SALDO nulo", contaPesquisada.getSaldo());
    	assertEquals(contaModelo.isAtiva(), contaPesquisada.isAtiva(),"STATUS ATIVAÇÃO incorreto ou nulo");
    	assertNotNull("STATUS ATIVAÇÃO nulo", contaPesquisada.isAtiva());
    }
    
    @Test
    @Order(3)
    public void testePesquisaConta(){
    	ContaCorrente contaModelo = new ContaCorrente(1, 1000.0, true);
    	ContaCorrente contaPesquisada = cDAO.pesquisaConta(1);
    	
    	assertNotNull("Conta não existente/nulo", contaPesquisada);
    	assertEquals(contaModelo.getId(), contaPesquisada.getId(),"ID incorreto ou nulo");
    	assertNotNull("ID nulo", contaPesquisada.getId());
    	assertEquals(contaModelo.getSaldo(), contaPesquisada.getSaldo(), "SALDO incorreto ou nulo");
    	assertNotNull("SALDO nulo", contaPesquisada.getSaldo());
    	assertEquals(contaModelo.isAtiva(), contaPesquisada.isAtiva(),"STATUS ATIVAÇÃO incorreto ou nulo");
    	assertNotNull("STATUS ATIVAÇÃO nulo", contaPesquisada.isAtiva());
    }
    
    @Test
    @Order(1)
    public void testeAdicionarConta(){
    	ContaCorrente contaNova = new ContaCorrente(3, 1200.0, true);
    	int tamanhoListaContasAntes = cDAO.getContasDoBanco().size();
    	cDAO.adicionaConta(contaNova);
    	int tamanhoListaContasDepois = cDAO.getContasDoBanco().size();
    	assertEquals(tamanhoListaContasAntes + 1, tamanhoListaContasDepois);
    	
    	ContaCorrente contaPesquisada = cDAO.pesquisaConta(3);
    	
    	assertNotNull("Conta não existente/nulo", contaPesquisada);
    	assertEquals(contaNova.getId(), contaPesquisada.getId(),"ID incorreto ou nulo");
    	assertNotNull("ID nulo", contaPesquisada.getId());
    	assertEquals(contaNova.getSaldo(), contaPesquisada.getSaldo(), "SALDO incorreto ou nulo");
    	assertNotNull("SALDO nulo", contaPesquisada.getSaldo());
    	assertEquals(contaNova.isAtiva(), contaPesquisada.isAtiva(),"ST	ATUS ATIVAÇÃO incorreto ou nulo");
    	assertNotNull("STATUS ATIVAÇÃO nulo", contaPesquisada.isAtiva());
    }
    
    @Test
    @Order(1)
    public void testeRemoveConta(){
    	int tamanhoListaContasAntes = cDAO.getContasDoBanco().size();
    	cDAO.removeConta(3);
    	int tamanhoListaContasDepois = cDAO.getContasDoBanco().size();
    	assertEquals(tamanhoListaContasAntes - 1, tamanhoListaContasDepois, "Conta não foi removido");
    	assertNull(cDAO.pesquisaConta(3));
    }
    
    @Test
    @Order(1)
    public void testeContaAtiva(){
    	assertTrue(cDAO.contaAtiva(1));
    }
    
    @Test
    @Order(1)
    public void testeTransfereValor(){
    	
    }
}
