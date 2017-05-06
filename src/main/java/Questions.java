import org.openqa.selenium.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Kerens on 06/05/2017.
 */
public class Questions {

    static String keyword;
    static String url;

    public static void main (String[] args){
        question1();
        question2();
    }

    public static void question1(){
        WebDriver driver = null;
        By searchField = By.cssSelector("#lst-ib");

        keyword = getKeyword();
        driver = baseClass.setDriver("chrome", "http://google.com");
        //driver.navigate().to("http://google.com");
        // TBD - might want to consider wait for site to load function here

        WebElement element = driver.findElement(searchField);
        element.sendKeys(keyword);
        element.sendKeys(Keys.RETURN);

        // driver.quit(); - Commented for testing
    }

    //This one was a bit of a ponder. I believe I found a way to download the assets.
    //The log and timestamps should provide the download time of the assets
    //https://www.gnu.org/software/wget/manual/wget.html#Logging-and-Input-File-Options
    public static void question2(){
        url = getURL();
        try {
            execCmd("wget --page-requisites  -o log --timestamping " + url); //need to install the wget locally
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void execCmd(String cmd) throws java.io.IOException {
        Runtime.getRuntime().exec(cmd);
    }

    private static void executeScript(String script, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    private static String getKeyword(){
        System.out.println("Please type your keyword");
        String key;
        Scanner sc = new Scanner(System.in);
        do {
            key = sc.nextLine();
        } while (key.isEmpty());
        return key;

        //Could also implement directly into the members
    }

    private static String getURL(){
        System.out.println("Please type your URL");
        String urlAddress;
        Scanner sc = new Scanner(System.in);
        do {
            urlAddress = sc.nextLine();
        } while (urlAddress.isEmpty());
        return urlAddress;
    }
}
