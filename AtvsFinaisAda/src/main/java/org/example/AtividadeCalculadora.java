package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AtividadeCalculadora {

    private WebDriver driver;
    private final String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";

//    WebElement botaoSoma = driver.findElement(By.id("add"));
//    WebElement botaoSubtracao = driver.findElement(By.id("subtract"));
//    WebElement botaoMultiplicacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/button[3]"));
//    WebElement botaoDivisao = driver.findElement(By.cssSelector("#divide"));
//
//    WebElement botaoClear = driver.findElement(By.id("clear"));
//
//    WebElement botaoIgual = driver.findElement(By.id("equals"));
//
//    WebElement botao0 = driver.findElement(By.id("zero"));
//    WebElement botao1 = driver.findElement(By.id("one"));
//    WebElement botao2 = driver.findElement(By.id("two"));
//    WebElement botao3 = driver.findElement(By.id("three"));
//    WebElement botao4 = driver.findElement(By.id("four"));
//    WebElement botao5 = driver.findElement(By.id("five"));
//    WebElement botao6 = driver.findElement(By.id("six"));
//    WebElement botao7 = driver.findElement(By.id("seven"));
//    WebElement botao8 = driver.findElement(By.id("eight"));
//    WebElement botao9 = driver.findElement(By.id("nine"));
//
//    WebElement display = driver.findElement(By.id("display"));


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
    public void ValidaSoma() {

        WebElement botao3 = driver.findElement(By.id("three"));
        WebElement botao1 = driver.findElement(By.id("one"));
        WebElement botao9 = driver.findElement(By.id("nine"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement botaoSoma = driver.findElement(By.id("add"));
        WebElement display = driver.findElement(By.id("display"));


        botao3.click();
        botao1.click();

        botaoSoma.click();

        botao9.click();


        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("31+9", displayAntes);

        Assertions.assertEquals("40", displayDepois);


    }

    @Test
    public void ValidaSubtracao() {

        WebElement botaoSubtracao = driver.findElement(By.id("subtract"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao4 = driver.findElement(By.id("four"));
        WebElement botao5 = driver.findElement(By.id("five"));


        botao4.click();

        botaoSubtracao.click();

        botao5.click();


        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("4-5", displayAntes);

        Assertions.assertEquals("-1", displayDepois);


    }

    @Test
    public void ValidaMultiplicacao() {

        WebElement botaoMultiplicacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/button[3]"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao8 = driver.findElement(By.id("eight"));
        WebElement botao1 = driver.findElement(By.id("one"));


        botao8.click();

        botaoMultiplicacao.click();

        botao1.click();

        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("8*1", displayAntes);

        Assertions.assertEquals("8", displayDepois);

    }

    @Test
    public void ValidaDivisao() {

        WebElement botaoDivisao = driver.findElement(By.cssSelector("#divide"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao7 = driver.findElement(By.id("seven"));
        WebElement botao2 = driver.findElement(By.id("two"));


        botao7.click();

        botaoDivisao.click();

        botao2.click();

        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("7/2", displayAntes);

        Assertions.assertEquals("3.5", displayDepois);

    }

    @Test
    public void ValidaDivisaoPorZero() {

        WebElement botaoDivisao = driver.findElement(By.cssSelector("#divide"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao7 = driver.findElement(By.id("seven"));
        WebElement botao0 = driver.findElement(By.id("zero"));


        botao7.click();

        botaoDivisao.click();

        botao0.click();

        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("7/0", displayAntes);

        Assertions.assertEquals("Infinity", displayDepois);

    }

    @Test
    public void ValidaBotaoClear() {

        WebElement botaoDivisao = driver.findElement(By.cssSelector("#divide"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement botaoClear = driver.findElement(By.id("clear"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao7 = driver.findElement(By.id("seven"));
        WebElement botao0 = driver.findElement(By.id("zero"));


        botao7.click();

        botaoDivisao.click();

        botao0.click();

        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        botaoClear.click();

        String displayDepoisClear = display.getAttribute("value");

        Assertions.assertEquals("7/0", displayAntes);

        Assertions.assertEquals("Infinity", displayDepois);

        Assertions.assertEquals("", displayDepoisClear);

    }

    @Test
    public void TesteCapturaBugMultiplasOperacoes() {
        WebElement botao3 = driver.findElement(By.id("three"));
        WebElement botao1 = driver.findElement(By.id("one"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement botaoSoma = driver.findElement(By.id("add"));
        WebElement display = driver.findElement(By.id("display"));

        botao1.click();
        botao1.click();

        String display11 = display.getAttribute("value");

        Assertions.assertEquals("11", display11);

        botaoSoma.click();
        botaoSoma.click();

        String displaySimboloSoma = display.getAttribute("value");

        Assertions.assertEquals("11+", displaySimboloSoma);

        botao3.click();

        String displayAntesSoma = display.getAttribute("value");

        Assertions.assertEquals("11+3", displayAntesSoma);

        botaoIgual.click();

        String displayAposSoma = display.getAttribute("value");

        Assertions.assertEquals("14", displayAposSoma);

    }

    @Test
    public void ValidaPotenciaThisIsAFeatureNotABug() {

        WebElement botaoMultiplicacao = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/button[3]"));
        WebElement botaoIgual = driver.findElement(By.id("equals"));
        WebElement display = driver.findElement(By.id("display"));

        WebElement botao8 = driver.findElement(By.id("eight"));
        WebElement botao2 = driver.findElement(By.id("two"));


        botao8.click();

        botaoMultiplicacao.click();
        botaoMultiplicacao.click();

        botao2.click();

        String displayAntes = display.getAttribute("value");

        botaoIgual.click();

        String displayDepois = display.getAttribute("value");

        Assertions.assertEquals("8**2", displayAntes);

        Assertions.assertEquals("64", displayDepois);

    }
}
