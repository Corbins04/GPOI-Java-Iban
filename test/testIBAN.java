import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testIBAN {


    private IBAN iban;

    @Before
    public void init(){
        iban = new IBAN();
    }

    @Test
    public void testVerificaIbanValido(){
        iban.setIban("IT29N0300203280817788284423");
        assertTrue(iban.verificaIban());
    }

    @Test
    public void testVerificaIbanNonValido(){
        iban.setIban("IT29N0300203280817788284424");
        assertFalse(iban.verificaIban());
    }

    @Test
    public void testVerificaIbanLunghezza(){
        iban.setIban("IT29N030020328081778828442400000000");
        assertFalse(iban.verificaIban());
    }

    @Test
    public void testVerificaIbanVuoto(){
        iban.setIban("");
        assertThrows(NullPointerException.class, () -> {
            iban.verificaIban();
        } );
    }
}

