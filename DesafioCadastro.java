import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DesafioCadastro {
	
	@Test
	public void CadastroCompletro(){
		//Definindo navegador e abrindo página
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//Preenchendo formulário
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Carlos");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		

		// Selecionando opção do dropdown
		//WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(escolaridade);
		//combo.selectByValue("superior");
		
		//Outra forma prática de selecionar uma opção do dropdown
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByValue("superior");
		

		WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select(esporte);
		combo2.selectByValue("natacao");
		combo2.selectByValue("futebol");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		//Verificando valores apresentados abaixo após cadastro
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Carlos"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Souza"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Carne Frango Pizza"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao Futebol"));

		
		//Assert.assertEquals("Nome: Carlos", driver.findElement(By.id("descNome")).getText());
		//Assert.assertEquals("Sobrenome: Souza", driver.findElement(By.id("descSobrenome")).getText());
		//Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		//Assert.assertEquals("Comida: Carne Frango Pizza", driver.findElement(By.id("descComida")).getText());
		//Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		//Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());

		
		
		
		driver.quit();
		
	}
	
}
