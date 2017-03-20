import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ACELevel3Test {

    public static void main(String[] arg0) throws IOException, URISyntaxException {
        String challengeValue = new String();
        Primes primes = new Primes();

        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        ACELevel3Test aceLevel3Test = new ACELevel3Test();
        WebDriver driver = aceLevel3Test.createFirefoxDriver();
        driver.get("http://5.9.247.121/d34dc0d3");

        challengeValue = driver.findElement(By.className("challenge")).getText().replace("[", "").replace("]", "");
        String finall = primes.getListOfPrimes(challengeValue).replaceFirst(",", "");
        aceLevel3Test.changeInnerValue(driver, "solution", finall);
        driver.findElement(By.name("solution")).submit();
    }

    public FirefoxDriver createFirefoxDriver() throws URISyntaxException, IOException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe");
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "OFF");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "OFF");

        final FirefoxProfile profile = new FirefoxProfile();
        final URL url = this.getClass().getResource("modify_headers-0.7.1.1-fx.xpi");
        final File modifyHeaders = new File(url.toURI());

        profile.setEnableNativeEvents(false);
        profile.addExtension(modifyHeaders);

        profile.setPreference("modifyheaders.headers.count", 1);
        profile.setPreference("modifyheaders.headers.action0", "Add");
        profile.setPreference("modifyheaders.headers.name0", "X-0x0ACE-Key");
        profile.setPreference("modifyheaders.headers.value0", "qg6ezQWreY8bZrDnwlEq2Jj0QdMvPzBDn0XN4L19ok6ROVGpKgW5axAmyZjP24LN");
        profile.setPreference("modifyheaders.headers.enabled0", true);
        profile.setPreference("modifyheaders.config.active", true);
        profile.setPreference("modifyheaders.config.alwaysOn", true);

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxDriver(capabilities);
    }

    public void changeInnerValue (WebDriver driver, String valueId, String newValue){
        WebElement element = driver.findElement(By.name(valueId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + newValue +"')", element);
    }


}
