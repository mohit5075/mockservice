	package com.example.MockServiceApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockServiceAppApplication

fun main(args: Array<String>) {
	runApplication<MockServiceAppApplication>(*args)
}
