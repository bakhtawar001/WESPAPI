package APIs.WESP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;


import Pojo.ClipboardItems;
import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Pojo.CreateProject;
import Pojo.MyProject;
import Pojo.Products;;

public class WESPAPIs {
	
	
	public static String accessToken;
	public static String AddProductToClipboard;
	public static String GetProductFromClipboard;
	public static String GetAllProductFromClipboard;
	public static String AddProductAToClipboard;
	public static String AddProductBToClipboard;
	public static Response response;
	public static int ClipboardProductID;
	public static int ClipboardProductAID;
	public static int ClipboardProductBID;
	public static String SaveSearchProduct;
	public static String GetSavedProduct;
	public static String GetAllProjects;
	public static String GetAllProductsFromProject;
	public static String GetAllPresentationFromProject;
	public static  List<Integer> ids;
	public static int	projectid;

	
	public static int SaveSearchProductId;
	public static  Integer[] integers;
	public static  int[] primitives;
	static Random keychainrandom=new Random();
	static int keychainvalue=keychainrandom.nextInt(5000);
	
	
	static Random Projectname=new Random();
	static int ProjectName=Projectname.nextInt(5000);
	static String AghaPro="AghaProject"+ProjectName;
	public static String PostProject;
	
	//Token generation against 125748/CRMRegression1/Pakistan786
	 
    public static void WESP_Signin() throws IOException {
        try
        {
        	
        	Response response =RestAssured.given()
            .header("Content-Type","application/x-www-form-urlencoded")
            .header("Authorization","Basic NTAwMDU4Mjk0Ojg1Mjk0NDgyZWIzODdmMDhmODk0Y2U1N2ExNjg0NmRh")
            .formParam("grant_type", "password")
            .formParam("asi_number", "125748")
            .formParam("username", "CRMRegression1")
            .formParam("password", "Pakistan786")
            .post("https://authentication.uat-asicentral.com/oauth2/token?appCode=WESP&appVersion=4.1.0");	
            System.out.println("API Response >>> "+response.jsonPath().prettify());
            accessToken=response.jsonPath().get("access_token");
            System.out.println("API Response >>> "+accessToken);

        } 
        catch (Exception e) 
        {
            System.out.println("ERROR: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        
 }
	
    public static void AddProductTo_Clipboard() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	FileInputStream InputFile=new FileInputStream(new File("JSONFiles\\AddProductToClipboard.json"));
    	request.body(IOUtils.toByteArray(InputFile));
    	response=request.post("https://api.uat-asicentral.com/v1/clipboard.json");
    	AddProductToClipboard=response.jsonPath().prettyPrint();
    	System.out.println("Product Add To Clipboard>>>>"+AddProductToClipboard);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	ClipboardProductID=jsonPathEvaluator.get("Id");
    	System.out.println("Clipboard Product ID >>>>"+ClipboardProductID);
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    
    public static void GetProductFrom_Clipboard() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.get("https://api.uat-asicentral.com/v1/clipboard/"+ClipboardProductID+".json");
    	GetProductFromClipboard=response.jsonPath().prettyPrint();
    	System.out.println("Get Product From Clipboard>>>>"+GetProductFromClipboard);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    public static void DeleteProductFrom_Clipboard() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.delete("https://api.uat-asicentral.com/v1/clipboard/"+ClipboardProductID+".json");
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    
    public static void AddProductATo_Clipboard() throws IOException
    {
    	
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	FileInputStream InputFile=new FileInputStream(new File("JSONFiles\\AddProductToClipboard.json"));
    	request.body(IOUtils.toByteArray(InputFile));
    	response=request.post("https://api.uat-asicentral.com/v1/clipboard.json");
    	AddProductAToClipboard=response.jsonPath().prettyPrint();
    	System.out.println("Product A Add To Clipboard>>>>"+AddProductAToClipboard);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	ClipboardProductAID=jsonPathEvaluator.get("Id");
    	System.out.println("Clipboard Product ID >>>>"+ClipboardProductAID);
    	Assert.assertEquals(response.getStatusCode(), 200);
    }
    public static void AddProductBTo_Clipboard() throws IOException
    {
    	
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	FileInputStream InputFile=new FileInputStream(new File("JSONFiles\\AddProductBToClipboard.json"));
    	request.body(IOUtils.toByteArray(InputFile));
    	response=request.post("https://api.uat-asicentral.com/v1/clipboard.json");
    	AddProductBToClipboard=response.jsonPath().prettyPrint();
    	System.out.println("Product B Add  To Clipboard>>>>"+AddProductBToClipboard);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	ClipboardProductBID=jsonPathEvaluator.get("Id");
    	System.out.println("Clipboard Product B ID >>>>"+ClipboardProductBID);
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    }
    public static void GetAllProductFrom_Clipboard() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.get("https://api.uat-asicentral.com/v1/clipboard.json");
    	GetAllProductFromClipboard=response.jsonPath().prettyPrint();
    	System.out.println("Get All Product From Clipboard>>>>"+GetAllProductFromClipboard);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    public static void DeleteAllProductFrom_Clipboard() throws IOException
    {
    	/*List<Integer> clipboarditems=new ArrayList<Integer>();
    	clipboarditems.add(ClipboardProductAID);
    	clipboarditems.add(ClipboardProductBID);
    	
    	ClipboardItems payloadEmail=new ClipboardItems("WESP","4.0.1");
    	payloadEmail.setItems(clipboarditems);*/
    	
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	
    	response=request.delete("https://api.uat-asicentral.com/v1/clipboard?ids="+ClipboardProductAID+","+ClipboardProductBID);
    	
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    public static void SaveSearchProduct() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	FileInputStream InputFile=new FileInputStream(new File("JSONFiles\\SaveSearch.json"));
    	request.body(IOUtils.toByteArray(InputFile));
    	
    	response=request.post("https://api.uat-asicentral.com/v1/saved_search.json");
    	/*SaveSearchProduct=response.jsonPath().prettyPrint();
    	System.out.println("Save Search Product>>>>"+SaveSearchProduct);*/
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	/*JsonPath jsonPathEvaluator = response.jsonPath();
    	SaveSearchProduct=jsonPathEvaluator.get("id");
    	System.out.println("Save Search Product ID >>>>"+SaveSearchProduct);*/
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    public static void GetSaveSearchProduct() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.get("https://api.uat-asicentral.com/v1/saved_searches.json");
    	GetSavedProduct=response.jsonPath().prettyPrint();
    	ids= response.jsonPath().getList("Id");
    	SaveSearchProductId=ids.get(0);
    	System.out.println(SaveSearchProductId);
    	
    	/*integers = ids.toArray(new Integer[ids.size()]);
    	primitives = ArrayUtils.toPrimitive(integers);
    	System.out.println("Array with primitive int : " + Arrays.toString(primitives));*/
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    
    public static void UpdateSaveSearchProduct() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	JSONObject json=new JSONObject();
	   	json.put("name","Albums"+keychainvalue);
	   	json.put("id",SaveSearchProductId);
    	request.body(json.toString());
    	response=request.put("https://api.uat-asicentral.com/v1/saved_search.json");
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    public static void DeleteSaveSearchProduct() throws IOException
    {
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.delete("https://api.uat-asicentral.com/v1/saved_search/"+SaveSearchProductId+".json");
    	
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	
    	
    }
    
    public static void CreateProject() throws IOException
    {
    	
    	CreateProject postproject=new CreateProject(AghaPro,"4.1.0","WESP",520871);
	 	
	 	System.out.println("payloadEmail"+postproject.toString());
    	RequestSpecification request=RestAssured.given();
    	request.header("Authorization", "Bearer " +accessToken);
    
    	request.header("Content-Type","application/json");
    	request.header("Accept","application/x-www-form-urlencoded");
    	request.body(postproject);
	   	response=request.post("https://espweb.uat-asicentral.com/Modules/ClientProjects/4_0_0/ClientProjectsService.asmx/CreateProject");
    	System.out.println("Get Orders Status Code>>> "+response.getStatusCode());
    	System.out.println("PostReorder_UnderOrder >>> "+response.prettyPeek().prettyPrint());
    	PostProject=response.prettyPeek().prettyPrint();
    	
    	Assert.assertEquals(response.getStatusCode(),200);

    	
    }
    
    public static void GetProject() throws IOException
    {
    	
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.get("https://api.uat-asicentral.com/v1/projects.json");
    	GetAllProjects=response.jsonPath().prettyPrint();
    	System.out.println("Get All Projects>>>>"+GetAllProjects);
    	Gson gson = new Gson();
    	MyProject[] pojo=gson.fromJson(GetAllProjects, MyProject[].class);

    	int length = Array.getLength(pojo );
    		System.out.println(length );
    		
    		for(int i=0;i<=length-1;i++)
    		{
    		int	arraysize	=pojo[i].getProjects().size();
    		System.out.println(arraysize );
    		for(int j=0;j<=arraysize-1;j++)
    		{
    			
    		//	int	projectid=pojo[i].getProjects().get(j).getId();
    		//	System.out.println("ProjectId>>> "+projectid);
    			String	projectname=pojo[i].getProjects().get(j).getName();
    			System.out.println("ProjectName>>> "+projectname);
    			if (projectname.equalsIgnoreCase("AghaProject123"))
    			{
    				projectid=pojo[i].getProjects().get(j).getId();
        			System.out.println("ProjectId>>> "+projectid);
    				Assert.assertTrue(true);
    				break;
    			}
    		
    		}
    		
    	
    		}
    	
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	

    	
    }
    public static void GetProductFromProject() throws IOException
    {
    	
    	RequestSpecification request=RestAssured.given();
    	request.header("Content-Type","application/json");
    	request.header("Authorization","Bearer " +accessToken);
    	request.expect().defaultParser(Parser.JSON);
    	response=request.get("https://api.uat-asicentral.com/v1/projects/"+projectid+"/products.json");
    	GetAllProductsFromProject=response.jsonPath().prettyPrint();
    	System.out.println("Get All Product From Project>>>>"+GetAllProductsFromProject);
    	Gson gson = new Gson();
    	Products pojo=gson.fromJson(GetAllProductsFromProject, Products.class);
    	String ProductName= pojo.getResults().get(0).getName();
    	System.out.println("Product Name>>>>"+ProductName);
    	Assert.assertEquals("6\" Premium Glow Stick",ProductName);
    	int ProductId= pojo.getResults().get(0).getId();
    	Assert.assertEquals(4951953,ProductId);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);
    	

    	
    }
    public static void GetPresentationFromProject() throws IOException
    {
    	
    	RequestSpecification request=RestAssured.given();
    	Response response =request
    	.header("Content-Type","application/json")
    	.header("Authorization","Bearer " +accessToken)
    	
    	.queryParam("filters", "{\"ProjectIds\":{\"terms\":[637760]}}")
    	.queryParam("from","1")
    	.queryParam("size", "10")
    	.queryParam("sortBy", "{\"updateDate\":\"desc\"}")
    	.get("https://esp.uat-asicentral.com/api/v1/presentations/search");
    	String jsonString = response.asString();
    	System.out.println(jsonString );
    	GetAllPresentationFromProject=response.jsonPath().prettyPrint();
    	System.out.println("Get All Presentation From Project>>>>"+GetAllPresentationFromProject);
    /*	Gson gson = new Gson();
    	Products pojo=gson.fromJson(GetAllPresentationFromProject, Products.class);
    	String ProductName= pojo.getResults().get(0).getName();
    	System.out.println("Product Name>>>>"+ProductName);
    	Assert.assertEquals("6\" Premium Glow Stick",ProductName);
    	int ProductId= pojo.getResults().get(0).getId();
    	Assert.assertEquals(4951953,ProductId);
    	System.out.println("Response Code>>>>"+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(), 200);*/
    	

    	
    }
    
}
