package testLab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MyApplication
fun main(){
    runApplication<MyApplication>()
}