package com.dimcica.laststicker.utility

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = ["com.dimcica.laststicker.helper"]
)
class LastStickerUtilityService

fun main(args: Array<String>) {
	runApplication<LastStickerUtilityService>(*args)
}
