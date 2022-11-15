package com.dimcica.laststicker.helper.crawler

import com.dimcica.laststicker.helper.model.CardDetail
import com.dimcica.laststicker.helper.model.Collection
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class CollectionCrawler {
    init {
        WebDriverManager
            .chromedriver()
            .setup()
    }

    fun scrape(collection: Collection): Collection {
        val driver = ChromeDriver()
        driver.get(collection.url)
        driver.findElement(By.cssSelector(".fc-cta-consent")).click()

        val name = driver.findElement(By.cssSelector("#content h1")).text
        val checklist = HashMap<String, CardDetail>()

        try {
            val checklistTable = driver.findElements(By.cssSelector("#checklist tbody tr"))

            for (cardRow in checklistTable) {
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

        return collection.copy(name = name, checklist = checklist)
    }
}
