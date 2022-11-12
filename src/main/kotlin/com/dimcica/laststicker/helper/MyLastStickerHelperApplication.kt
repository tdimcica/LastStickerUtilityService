package com.dimcica.laststicker.helper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = ["com.dimcica.laststicker.helper"]
)
class MyLastStickerHelperApplication

fun main(args: Array<String>) {
	runApplication<MyLastStickerHelperApplication>(*args)
}
