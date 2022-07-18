package de.tudresden.algorandjava;

import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.algorand.algosdk.v2.client.common.AlgodClient;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

public class AlgorandConnectionTest {
    @ParameterizedTest
    @CsvSource({
            "localhost, 1234, http://localhost:1234, false",
            "http://localhost, 1234, http://localhost:1234, false",
            "https://localhost, 1234, https://localhost:1234, false",
            "http://localhost:99, 1234, http://localhost:99, true",
            "https://localhost:850, 1234, https://localhost:850, true",
    })

    @Test 
    public void creepyTest() {
        assertThat("hello world").isEqualTo("hello world");
    }

    @Test
    public void addTwoNumberTest() {
        assertThat(2+2).isEqualTo(4);
    }

    @Test
    public void testAlgorandConnection() throws Exception {
        AlgorandConnection app = new AlgorandConnection();
        //Account newAccount = app.createAccount();
        //newAccount.gettingStartedExample(newAccount);
        assertThat(app.createAccount()).isNotNull();
    }

    @Test
    public void testLocalClient(String host, int port, String expectedPrefix, boolean expectError) {
        try {
            AlgodClient client = new AlgodClient(host, port, "secure"); 
            String url = client.TransactionParams().getRequestUrl(); 
            assertThat(url).startsWith(expectedPrefix);
        } catch(Exception ex)
        {
            assertThat(expectError).isTrue(); 
        }
    }
}
