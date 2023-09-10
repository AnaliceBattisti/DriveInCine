package br.edu.ufape.poo.driveincine.dados;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;

@SpringBootTest
class InterfaceColecaoClientTest {
    @Autowired
    private InterfaceColecaoCliente colecaoCliente;
   
    @Test
    void cadastrarCliente() {
        long qtdCliente = colecaoCliente.count();
        Endereco j = new Endereco("Geraldao", "123", "Boa Viagem", "Recife", "Pernambuco", "55294554");
        Cliente k = new Cliente(1, "Isabel", "9887135", "11546554648", j, "87940028922", "18/06/2002", "bebelminhaprima", "gata123");
    
    	colecaoCliente.save(k);
        long qtdAposNovo = colecaoCliente.count();
        assertEquals(qtdCliente + 1, qtdAposNovo);
    
    }
    /*
    @Test
    public void testAssociarEnderecoPessoa() {
        assertNotNull(Cliente.getEndereco());
        assertEquals("Geraldao", Cliente.getEndereco().getRua());
        assertEquals("123", Cliente.getEndereco().getNumero());
        assertEquals("Boa Viagem", Cliente.getEndereco().getBairro());
        assertEquals("Recife", Cliente.getEndereco().getCidade());
        assertEquals("Pernambuco", Cliente.getEndereco().getEstado());
        assertEquals("55294554", Cliente.getEndereco().getCep());
    }
*/
   
}
