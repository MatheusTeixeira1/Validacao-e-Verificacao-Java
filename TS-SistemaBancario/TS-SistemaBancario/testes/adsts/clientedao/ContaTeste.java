package adsts.clientedao;

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
    	
    }
    
    @Test
    @Order(2)
    public void testeGetContasBanco(){
    	
    }
    
    @Test
    @Order(3)
    public void testePesquisaConta(){
    	
    }
    
    @Test
    @Order(1)
    public void testeAdicionarConta(){
    	
    }
    
    @Test
    @Order(1)
    public void testeRemoveConta(){
    	
    }
    
    @Test
    @Order(1)
    public void testeContaAtiva(){
    	
    }
    
    @Test
    @Order(1)
    public void testeTransfereValor(){
    	
    }
}
