package com.dimcica.laststicker.helper.crawler

import com.dimcica.laststicker.helper.model.CardDetail
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class CollectionChecklistCrawler {
    init {
        WebDriverManager
            .chromedriver()
            .setup()
    }

    fun getCollectionChecklist(url: String): Map<String, CardDetail> {
        val checklist = HashMap<String, CardDetail>()

        val driver = ChromeDriver()
        driver.get(url)
        driver.findElement(By.cssSelector(".fc-cta-consent")).click()

        try {
            val collectionChecklistTable = driver.findElements(By.cssSelector("#checklist tbody tr"))

            for (cardRow in collectionChecklistTable) {
                val cardRowColumns = cardRow.findElements(By.cssSelector("td"))
                val id = cardRowColumns[0].text
                val title = cardRowColumns[1].text
                val section = cardRowColumns[2].text
                val type = cardRowColumns[3].text
                val need = cardRowColumns[4].text
                val offer = cardRowColumns[5].text
                checklist[id] = CardDetail(title, section, type, need.toInt(), offer.toInt())
            }
        } finally {
            driver.quit()
        }

        return checklist
    }
}
