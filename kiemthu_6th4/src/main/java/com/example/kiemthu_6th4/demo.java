package com.example.kiemthu_6th4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo {
    public static void main(String[] args) {
        // Thiết lập đường dẫn đến EdgeDriver
        System.setProperty("webdriver.edge.driver", "F:\\edgedriver_win64\\msedgedriver.exe");
        // Khởi tạo đối tượng driver
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        // Mở trang web đầu tiên
        driver.get("https://fpl1.poly.edu.vn");
        // Chờ 10 giây
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Tiến hành chuyển đến trang Facebook
        driver.get("https://www.facebook.com");
        // Đóng trình duyệt
        driver.quit();
    }
}
