import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestAlerta {

	//Testando confirmação do alerta Simples
	@Test
	public void TestAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String alerta = alert.getText();
		Assert.assertEquals("Alert Simples", alerta);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(alerta);
		
		driver.close();
	}
	
	//Testando alerta com confirmação
	@Test
	public void TestAlertaConfirma() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String alerta = alert.getText();
		Assert.assertEquals("Confirm Simples", alerta);
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void TestAlertaPrompt() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		
		driver.quit();
		
	}
	
}
