package com.dimcica.mylaststickerhelper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = ["com.dimcica.mylaststickerhelper"]
)
class MyLastStickerHelperApplication

fun main(args: Array<String>) {
	runApplication<MyLastStickerHelperApplication>(*args)
}
