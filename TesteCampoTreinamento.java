import org.junit.Test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

///Classe para treinar Elementos Básicos.
	
	
	@Test
	public void TesteTextField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste");
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.close();
	
	}
	
	@Test
	public void TesteTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste \n");
		Assert.assertEquals("Teste \n", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
		driver.close();
	}
	
	@Test
	public void TesteRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.close();
	}
	
	@Test
	public void TesteCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
		
		
		
		driver.close();
	}
	
	@Test
	public void TesteCombo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(2);
//		combo.selectByValue("2o grau completo");
		combo.selectByVisibleText("Superior");
		
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		driver.close();
	}
	
	@Test
	public void TesteVerificaValoresCombo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> opcoes = combo.getOptions();
		Assert.assertEquals(8, opcoes.size());
		
		boolean encontrou = false;
		
		for(WebElement opcao: opcoes) {
			if(opcao.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
			
		}
		Assert.assertTrue(encontrou);
		
		driver.close();
	}
	
// Testando Textos em um combo de MultiplaEscolha. Também testando alteração de texto ao clicar em um link	
	@Test
	public void TesteComboMultiEscolha() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");		
		
		WebElement elemento2 = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select (elemento2);
		combo2.selectByVisibleText("Natacao");
		combo2.selectByVisibleText("Futebol");	
		combo2.selectByVisibleText("Karate");
		
		List<WebElement> allSelectedOptions = combo2.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo2.deselectByVisibleText("Karate");
		allSelectedOptions = combo2.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
//		driver.findElement(By.id("buttonSimple")).click();
//		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		
		
		
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
		
		driver.close();
		
	}
	
//Testando botões	
	@Test
	public void TesteButton() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		driver.close();

	}

// Buscando textos por tags
	@Test
	public void TestDiv() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		driver.close();
		
		
	}
	
	
	
}
