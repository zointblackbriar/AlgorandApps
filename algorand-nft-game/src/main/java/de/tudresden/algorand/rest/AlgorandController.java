package de.tudresden.algorand.rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algorand.algosdk.v2.client.common.AlgodClient;
import com.algorand.algosdk.account.Account;
@RestController
public class AlgorandController {
	
	
	@Autowired
	private Account account; 
	@Autowired
	private AlgodClient client; 
//	@Autowired
//	private IndexerClient indexer; 
	
	String[] headers = {"X-API-headers"}; 
	String[] values = {"y7R1UMWTHy9nvkOjSCyyS6AuEX1fEuXy3EJv6STa"}; //Your api key is here
	
	
	public static Properties properties = null;

	public static synchronized Properties getInstance() {
		if (properties == null) {
			try (InputStream resourceStream = new FileInputStream("src/main/resources/application.properties")) {
				properties = new Properties();
				if (resourceStream != null) {
					properties.load(resourceStream);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	
//	public AlgorandController() {
//		Properties properties = getInstance();
//		headers.add(properties.getProperty("algorand.algodclient.host").toString());
//		String user = properties.getProperty("spark.user").toString();
//		String password = null;
//
//	}
	
	@GetMapping(path="/getaccountinfo", produces = "application/json; charset=UTF-8")
	public String getAccountInfo() throws Exception {
		return client.AccountInformation(account.getAddress()).execute(headers, values).body().toString();
	}
	
//	@GetMapping(path="/accountassetsearch", produces="application/json; charset=UTF-8")
//	public String accountAssetSearch(@RequestParam String assetName) {
//		
//		Asset returnAsset = null;
//		try {
//			returnAsset = new Asset();
//			List<Asset> createdAssets = client.AccountInformation(account.getAddress()).execute(headers, values).body().createdAssets;
//			for(Asset asset : createdAssets) {
//				if(asset.params.name.equals(assetName)) {
//					returnAsset = asset;
//				}
//			}
//		} catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		
//		return returnAsset.toString();
//	}
//	
//    /**
//     * A method to search for an asset by name using the indexer
//     * @param assetId The id of the asset to be investigated
//     * @return String result parameter from GetPendingTransactionByAddress function
//     * @throws Exception
//     */
//	@GetMapping(path="/asset", produces = "application/json; charset=UTF-8")
//	public String assertRetrieve(@RequestParam long assetId) {
//		String result = null;
//		try {
//			result =  client.GetPendingTransactionsByAddress(account.getAddress()).execute(headers, values).toString();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return result;
//	}
	
}
