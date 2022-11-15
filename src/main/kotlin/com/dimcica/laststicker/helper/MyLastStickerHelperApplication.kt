package com.dimcica.laststicker.helper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(
	scanBasePackages = ["com.dimcica.laststicker.helper"]
)
@EnableScheduling
class MyLastStickerHelperApplication

fun main(args: Array<String>) {
	runApplication<MyLastStickerHelperApplication>(*args)
}
