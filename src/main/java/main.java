import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\artur\\OneDrive\\Escritorio\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com.mx/");

        HacerSignUp(driver);
        MensajeError(driver);

        assertEquals("La dirección de correo electrónico ya está en uso",GetError(driver));
        System.out.println(GetError(driver));
        //driver.quit();
    }

    public static void HacerSignUp(WebDriver driver) throws InterruptedException {
        //Click en identificarse
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(2000);

        //Crear nueva cuenta
        driver.findElement(By.id("createAccountSubmit")).click();

        //Formulario
        driver.findElement(By.id("ap_customer_name")).sendKeys("Arturo");
        driver.findElement(By.id("ap_email")).sendKeys("arturo@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("123Tamarindo");
        driver.findElement(By.id("ap_password_check")).sendKeys("123Tamarindo");
        driver.findElement(By.id("a-autoid-0")).click();
        //Comentario de prueba

    }


    public static void MensajeError(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div/h4")));

    }

    public static String GetError(WebDriver driver){
        return driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div/h4")).getText();
    }
}
