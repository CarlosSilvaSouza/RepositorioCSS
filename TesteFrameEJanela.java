import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteFrameEJanela {

	@Test
	public void TestandoFrame() {
		//Definindo navegador e abrindo página
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				
		//comando para mudar o foco do selenium para o frame, como é usado para o Alerta
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alerta = driver.switchTo().alert();
		String msg = alerta.getText();
		alerta.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		driver.quit();
	}
	
	@Test
	public void TestandoJanela() {
		//Definindo navegador e abrindo página
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		//comando para mudar de janela no navegador
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		driver.switchTo().window("");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("E agora?");
		
		driver.quit();
		
	}
	
	@Test
	public void TestandoJanelaSemParametroTitulo() {
		//Definindo navegador e abrindo página
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
		
		driver.quit();
	}
}
