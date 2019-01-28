package br.com.garuca.testecvccorp.hotel

import br.com.garuca.testecvccorp.HotelList2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import org.springframework.web.client.RestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity








@RestController
class HotelController {
    @GetMapping("/hotels")
    fun gethotels(request: HttpServletRequest): Array<Hotel>? {

        val restTemplate = RestTemplate()

        val response = restTemplate.getForObject<Array<Hotel>>(
                "https://cvcbackendhotel.herokuapp.com/hotels/avail/1032",
                Array<Hotel>::class.java)
     return response
    }
}