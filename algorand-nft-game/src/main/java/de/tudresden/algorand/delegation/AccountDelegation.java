package de.tudresden.algorand.delegation;

import com.algorand.algosdk.v2.client.common.AlgodClient;
import com.algorand.algosdk.v2.client.common.Response;
import com.algorand.algosdk.v2.client.model.PendingTransactionResponse;
import com.algorand.algosdk.v2.client.model.PostTransactionsResponse;
import com.algorand.algosdk.v2.client.model.TransactionParametersResponse;
import java.util.logging.Logger;

public class AccountDelegation {
	
	private static final Logger logger = Logger.getLogger(AccountDelegation.class.getName());
	
	public AlgodClient client = null; 
	
	private AlgodClient connect2Network() {
		
		//Initialize the algo network in sandbox
		final String ALGORAND_API_ADDRESS = "localhost";
		final Integer ALGORAND_PORT = 4001;
		final String ALGORAND_API_TOKEN = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		AlgodClient client = new AlgodClient(ALGORAND_API_ADDRESS, ALGORAND_PORT, ALGORAND_API_TOKEN);
		return client; 
	}
	
	
	public void waitForConfirmation(String transaction) throws Exception {
		if(client == null) {
			this.client = connect2Network();
		}
		//Specify last round
		Long lastRound = client.GetStatus().execute().body().lastRound;
		while(true) {
			try	{
				Response<PendingTransactionResponse> pendingInfo = client.PendingTransactionInformation(transaction).execute(); //transaction ID
				if(pendingInfo.body().confirmedRound != null && pendingInfo.body().confirmedRound > 0) {
					logger.info("Transaction: " + transaction + " confirmed in round " + pendingInfo.body().confirmedRound);
					break;
				}
				lastRound++;
				client.WaitForBlock(lastRound).execute(); 
			} catch(Exception ex ) {
				ex.printStackTrace();
			}
		}
	} 
	
	public void accountDelegation() throws Exception{
		//Check the client is null
		if(client == null) {
			this.client = connect2Network(); 
		}
		
		final String SOURCE_ACCOUNT = "buzz genre work meat fame favorite rookie stay tennis demand panic busy hedgehog snow morning acquire ball grain grape member blur armor foil ability seminar";
		
		
	}
}
