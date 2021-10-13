package testLab.controllers


import org.springframework.web.bind.annotation.*

import testLab.service.DuodigitService

@RestController

@RequestMapping( "/api")
class DuodigitController(private val duodigitService: DuodigitService){

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping( "/isduodigit/{number}")
    fun findSmallestMultiplier(@PathVariable number: Long): String {
        return duodigitService.getResp(number)
    }

}
