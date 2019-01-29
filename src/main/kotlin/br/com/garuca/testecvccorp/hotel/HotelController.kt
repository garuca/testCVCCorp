package br.com.garuca.testecvccorp.hotel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
class HotelController {
    @Autowired
    private val hotelService :HotelService? =null
    @GetMapping("/hotels")
    fun get(request: HttpServletRequest,@RequestParam("cityCode") cityCode:Int,
                                        @RequestParam("checkin") checkin:String,
                                        @RequestParam("checkout") checkout:String,
                                        @RequestParam("adult") adult:Int,
                                        @RequestParam("child") child:Int): Array<Hotel>?{


        val hotels :Array<Hotel>? = hotelService?.getHotels(cityCode = cityCode)
        return hotelService?.applyCommission(checkin,checkout,adult,child,hotels)
    }
    @GetMapping("/hotel/{cityCode}")
    fun getHotel(request: HttpServletRequest, @PathVariable("cityCode") cityCode:Int,
                 @RequestParam("checkin") checkin:String,
                 @RequestParam("checkout") checkout:String,
                 @RequestParam("adult") adult:Int,
                 @RequestParam("child") child:Int): Array<Hotel>?{


        val hotels :Array<Hotel>? = hotelService?.getHotel(cityCode = cityCode)
        return hotelService?.applyCommission(checkin,checkout,adult,child,hotels)
    }
}