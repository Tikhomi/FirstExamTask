package pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BoardPage {
    public static SelenideElement searchTask = $x("//a[@id='issues_new_search_link_lnk']");
    public static SelenideElement panelTask = $x("//a[@class='filter-link' and text()='Все задачи']");
    public static SelenideElement upPanel = $x("//a[@id='find_link']");
    public static SelenideElement quantity = $x("//div[@class='showing']");
    public static SelenideElement allTasks = $x("//div[@class='showing']");
}
