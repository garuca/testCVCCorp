package br.com.garuca.testecvccorp

import br.com.garuca.testecvccorp.hotel.Hotel
import br.com.garuca.testecvccorp.hotel.Price
import br.com.garuca.testecvccorp.hotel.Room
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HotelTest {
    @Test
    fun totalCalculation(){
        val hotel = Hotel()
        hotel.id = 1
        hotel.cityCode = 1032
        hotel.cityName = "Porto Seguro"
        val room = Room()
        room.roomID = 1
        room.categoryName = "Stamdart"
        val price = Price()
        price.adult = 100f
        price.child = 50f
        room.price = price
        hotel.rooms = arrayOf(room)
        hotel.calculate(checkin ="05/05/2018",checkout = "05/06/2018",numberAdult = 1,numberChild = 1)
        assert(hotel.totalCalculation(checkin ="05/05/2018",checkout = "05/06/2018",numberAdult = 1,numberChild = 1,room = room) == 150f)
    }
    @Test
    fun addCommissionTest(){
        val hotel = Hotel()
        assert(hotel.addCommission(150f) == 195f)
    }
}