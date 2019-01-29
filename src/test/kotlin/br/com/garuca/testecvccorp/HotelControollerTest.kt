package br.com.garuca.testecvccorp

import br.com.garuca.testecvccorp.hotel.Hotel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.client.RestTemplate

@SpringBootTest
class HotelControollerTest {
    val restTemplate = RestTemplate()
    var hotels:Array<Hotel>? = null
    @Before
    fun init(){
        if(hotels.isNullOrEmpty()) {
            hotels = restTemplate.getForObject(
                    "http://localhost:8080/hotels?cityCode=1032&checkin=05/05/2018&checkout=05/06/2018&adult=1&child=2",
                    Array<Hotel>::class.java)
        }
    }
    @Test
    fun greateOneTest(){


        assertThat(hotels?.size).isGreaterThan(1)

    }
    @Test
    fun idTest(){
        assertThat(hotels?.get(1)?.cityCode).isEqualTo(1032)

    }
    @Test
    fun totalPriceNotNullTest(){
        hotels!!.forEach {
            assertThat(it.totalPrice).isNotEqualTo(null)
        }

    }

}