package APIs.WESP;

import java.io.IOException;

import org.testng.annotations.Test;



public class ExecutionFile {
	
	 @Test(priority = 1)
	 public void WESP_Signin() throws IOException
	 { 
		WESPAPIs.WESP_Signin();
	 
	 }
	 
	 @Test(priority = 2)
	 public void AddProductToClipboard() throws IOException
	 {
		 WESPAPIs.AddProductTo_Clipboard();
	 }
	 @Test(priority = 3)
	 public void GetProductFromClipboard() throws IOException
	 {
		 WESPAPIs.GetProductFrom_Clipboard();
	 }
	 @Test(priority = 4)
	 public void DeleteProductFromClipboard() throws IOException
	 {
		 WESPAPIs.DeleteProductFrom_Clipboard();
	 }
	 @Test(priority = 5)
	 public void AddProductAToClipboard() throws IOException
	 {
		 WESPAPIs.AddProductATo_Clipboard();
	 }
	 @Test(priority = 6)
	 public void AddProductBToClipboard() throws IOException
	 {
		 WESPAPIs.AddProductBTo_Clipboard();
	 }
	 @Test(priority = 7)
	 public void GetAllProductFrom_Clipboard() throws IOException
	 {
		 WESPAPIs.GetAllProductFrom_Clipboard();
	 }
	 @Test(priority = 8)
	 public void DeleteAllProductFromClipboard() throws IOException
	 {
		 WESPAPIs.DeleteAllProductFrom_Clipboard();
	 }
	 @Test(priority = 9)
	 public void SaveSearchProduct() throws IOException
	 {
		 WESPAPIs.SaveSearchProduct();
	 }
	 
	 @Test(priority = 10)
	 public void GETSearchProduct() throws IOException
	 {
		 WESPAPIs.GetSaveSearchProduct();
	 }
	 @Test(priority = 11)
	 public void UpdateSearchProduct() throws IOException
	 {
		 WESPAPIs.UpdateSaveSearchProduct();
	 }
	 @Test(priority = 12)
	 public void DeleteSearchProduct() throws IOException
	 {
	 WESPAPIs.DeleteSaveSearchProduct();
	 }
		 @Test(priority = 13)
	 public void PostProject() throws IOException
	 {
		 WESPAPIs.CreateProject();
	 }
	 @Test(priority = 14)
	 public void GetProject() throws IOException
	 {
		 WESPAPIs.GetProject();
	 }
	 @Test(priority = 15)
	 public void GetAllProducts() throws IOException
	 {
		 WESPAPIs.GetProductFromProject();
	 }
	 @Test(priority = 16)
	 public void GetPresentationFromProject() throws IOException
	 {
		 WESPAPIs.GetPresentationFromProject();
	 }
}

