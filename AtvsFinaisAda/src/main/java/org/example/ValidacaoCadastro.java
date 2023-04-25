package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidacaoCadastro {
    private WebDriver driver;
    private final String URL = "https://igorsmasc.github.io/fomulario_cadastro_selenium/";

    @BeforeEach
    public void BeforeEach() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void AfterEach() {
        driver.quit();
    }

    @Test
    public void ValidaCadastro() {
        WebElement nome = driver.findElement(By.name("nome"));
        WebElement sobrenome = driver.findElement(By.id("sobrenome"));

        WebElement masculino = driver.findElement(By.cssSelector("#masculino"));

        WebElement java = driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[1]/input"));

        WebElement selenium = driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[2]/input"));

        WebElement junit = driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[4]/input"));

        WebElement javascript = driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div[5]/input"));

        WebElement areasInteresse = driver.findElement(By.id("area-interesse"));
        Select selectAreasInteresse = new Select(areasInteresse);

        WebElement areaPrincipal = driver.findElement(By.id("motivacao"));
        Select selectAreaPrincipal = new Select(areaPrincipal);

        WebElement porQueVaga = driver.findElement(By.id("porque"));

        WebElement formulario = driver.findElement(By.id("formulario"));

        nome.sendKeys("Helcius");
        sobrenome.sendKeys("Cabral");
        masculino.click();
        java.click();
        selenium.click();
        junit.click();
        javascript.click();
        selectAreasInteresse.selectByValue("Backend");
        selectAreasInteresse.selectByValue("Testes");
        selectAreaPrincipal.selectByIndex(3);
        porQueVaga.sendKeys("Primeiramente por estar numa situação bastante delicada na qual um emprego é de extrema necessidade, mas também devo acrescentar que posso trazer um diferencial para o time devido minha formação de Engenheiro e devido minha fluência na língua Inglesa, sem falar na minha ótima capacidade de ter bons relacionamentos interpessoais");

        formulario.submit();

        driver.switchTo().alert().accept();

        String recebeNome = driver.findElement(By.xpath("//td[1]")).getText();
        String recebeSobrenome = driver.findElement(By.xpath("//td[2]")).getText();
        String recebeSexo = driver.findElement(By.xpath("//td[3]")).getText();
        String recebeAreasInteresse = driver.findElement(By.xpath("//td[4]")).getText();
        String recebeAreaPrincipal = driver.findElement(By.xpath("//td[5]")).getText();

        Assertions.assertEquals("Helcius", recebeNome);
        Assertions.assertEquals("Cabral", recebeSobrenome);
        Assertions.assertEquals("masculino", recebeSexo);
        Assertions.assertEquals("Backend, Testes", recebeAreasInteresse);
        Assertions.assertEquals("Testes", recebeAreaPrincipal);
    }
}
