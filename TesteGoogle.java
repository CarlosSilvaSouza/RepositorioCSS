import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteGoogle {
	
	@Test
	public void Teste() {
//		System.setProperty("webdriver.chrome.driver", "/Driver/chromedriver.exe"); #Comando para chamar o driver no diretório
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));    #Comando para setar o tamanho da janela do navegador
		driver.manage().window().maximize();
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google", driver.getTitle());
		
		//Comando para encerrar a aba do navegador. Para encerrar todos os processos, utilizar o quit()
		driver.close(); 
	}

}
