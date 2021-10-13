package testLab.service

import com.sun.xml.internal.ws.developer.Serialization
import org.springframework.stereotype.Service
import com.google.gson.Gson;


@Service
class DuodigitService {
    fun getResp(number: Long): String {
        return Gson().toJson(findSmallestMultiplier(number))
    }
    private fun checkNumberOfDigits(number: Any): Boolean{
        val numberList = number.toString().toSet()
        return numberList.size <= 2
    }
    private fun findSmallestMultiplier(number: Long): ApiResp {
        var numberIsDuoDigit = false
        var multipler = 2
        var minDuodigitMultiplier = 0L

       if(number <= 100){
           return ApiResp(

               msg = "Digite um numero maior que 100"
           )
       }else{
           while (!numberIsDuoDigit){
               numberIsDuoDigit = checkNumberOfDigits(number * multipler)
               if (numberIsDuoDigit){
                   minDuodigitMultiplier = (number * multipler)
               }else multipler += 1
           }
           return ApiResp(
               minDuodigit = minDuodigitMultiplier.toString(),
               multipler = multipler.toString(),
               msg = "ok"
           )
       }
    }


}
@Serialization
data class ApiResp(
    val minDuodigit: String? = null,
    val multipler: String? = null,
    val msg: String? = null
)
