package br.com.garuca.testecvccorp.hotel

import org.joda.time.DateTime
import org.joda.time.Days
import java.text.SimpleDateFormat
import java.util.*

open class Hotel{
    open var id:Int = -1
    open var cityCode:Int? = null
    open var cityName:String? = null
    open var rooms: Array<Room>? = null
    open var totalPrice: Float? = null

    private fun totalCalculation(checkin:String, checkout:String, numberAdult:Int, numberChild: Int, room:Room):Float?{
        val days = calcIntervalDays(checkin,checkout)
        return (numberChild*room.price?.child!! + numberAdult*room.price?.adult!!)*days!!.toFloat()
    }

    fun calculate(checkin:String,checkout:String,numberAdult:Int,numberChild: Int){
        Thread {
            for (room: Room in this.rooms!!) {
                val total = totalCalculation(checkin, checkout, numberAdult, numberChild, room)
                totalPrice = addCommission(total)
            }
        }.start()

    }
    fun addCommission(total:Float?):Float?{
        return total!!+total*0.3f
    }

    fun calcIntervalDays(dateStart:String,dateStop:String):Int?{
        val format = SimpleDateFormat("MM/dd/yyyy")
        val d1: Date?
        val d2: Date?

        d1 = format.parse(dateStart)
        d2 = format.parse(dateStop)

        val dt1 = DateTime(d1)
        val dt2 = DateTime(d2)
        return Days.daysBetween(dt1, dt2).days
    }

}

open class Room{
    open var roomID:Int = 0
    open var categoryName:String? = null
    open var price: Price? = null
}

open class Price{
    open var adult:Float? = null
    open var child:Float? = null
}


