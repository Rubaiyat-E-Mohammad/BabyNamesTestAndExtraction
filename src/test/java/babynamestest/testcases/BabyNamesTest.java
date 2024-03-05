package babynamestest.testcases;

import babynamestest.base.Base;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class BabyNamesTest extends Base {

    public WebDriver driver;

    public BabyNamesTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void AccessLinkTest() throws InterruptedException, IOException {

        Thread.sleep(2000);

        String Link = "https://adoption.com/baby-names/browse/";

        String[] pagelink = {"A", "B", "C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String filePath = "/Users/rubaiyatemohammad/work/LegoIO/babynames-test/names.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePath));
        String[] header = {"Name", "Meaning", "Gender", "Origin", "Similar"};
        writer.writeNext(header);
        for (String s : pagelink) {
            String newlink = Link + s + "?page=";
            for (int j = 1; j <= 179; j++) {
                if (s == "A" && j <= 179){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "B" && j <= 79){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "C" && j <= 68){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "D" && j <= 77){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "E" && j <= 41){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "F" && j <= 30){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "G" && j <= 51){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "H" && j <= 55){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "I" && j <= 26){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "J" && j <= 53){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "K" && j <= 77){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "L" && j <= 44){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "M" && j <= 100){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "N" && j <= 59){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "O" && j <= 18){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "P" && j <= 59){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "Q" && j <= 6){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "R" && j <= 67){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "S" && j <= 154){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "T" && j <= 58){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "U" && j <= 19){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "V" && j <= 47){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "W" && j <= 18){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "X" && j <= 3){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "Y" && j <= 19){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }else if(s == "Z" && j <= 16){
                    String createdlink = newlink + j;
                    ExtractData(createdlink, j, writer);
                }
            }
            System.out.println("Text has been written to the file successfully.");
        }

        writer.close();

    }

    private void ExtractData(String link, int count, CSVWriter writer) {

        try{
            driver.get(link);
            Thread.sleep(2000);
            String[] rowdata = new String[5];
            for (int i= 1; i<65; i++){
                String path = "/html/body/div/main/div[4]/div[2]/div/table/tbody/tr[" + i + "]" +"/td";
                if(i != 18 && i != 35 && i != 52){
                    for (int j = 1; j<6; j++){
                        String newpath = path + "[" + j + "]";
                        String text = driver.findElement(By.xpath(newpath)).getText();
//                        Thread.sleep(50);
                        rowdata[j-1] = text;
                    }
                    writer.writeNext(rowdata);
                }
            }
        }catch (Exception e){
            System.out.println(count);
        }

    }
}