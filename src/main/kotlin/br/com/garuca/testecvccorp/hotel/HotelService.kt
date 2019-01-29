package br.com.garuca.testecvccorp.hotel

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class HotelService {
   fun getHotels(cityCode:Int?):Array<Hotel>?{
       val restTemplate = RestTemplate()
       return restTemplate.getForObject(
               "https://cvcbackendhotel.herokuapp.com/hotels/avail/$cityCode",
               Array<Hotel>::class.java)

   }
    fun applyCommission(checkin:String,checkout:String,adult:Int,child: Int,hotels:Array<Hotel>?):Array<Hotel>?{
        hotels!!.forEachIndexed{ index, hotel->
            hotel.calculate(checkin,checkout,adult,child)
            hotels[index] =  hotel
        }
        return hotels

    }
}