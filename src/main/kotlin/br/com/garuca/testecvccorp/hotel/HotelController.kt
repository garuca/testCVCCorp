package br.com.garuca.testecvccorp.hotel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import org.springframework.web.client.RestTemplate


@RestController
class HotelController {
    @GetMapping("/hotels")
    fun get(request: HttpServletRequest,@RequestParam("cityCode") cityCode:Int,
                                        @RequestParam("checkin") checkin:String,
                                        @RequestParam("checkout") checkout:String,
                                        @RequestParam("adult") adult:Int,
                                        @RequestParam("child") child:Int): Array<Hotel>?{

       val restTemplate = RestTemplate()
       val hotels :Array<Hotel>? = restTemplate.getForObject(
               "https://cvcbackendhotel.herokuapp.com/hotels/avail/$cityCode",
               Array<Hotel>::class.java)
       hotels!!.forEachIndexed{ index, hotel->
           hotel.calculate(checkin,checkout,adult,child)
           hotels[index] =  hotel
       }

       return hotels
    }
}