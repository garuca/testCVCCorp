package br.com.garuca.testecvccorp.hotel
open class Hotel{
    open var id:Int = 0
    open var cityCode:Int? = null
    open var cityName:String? = null
    open var rooms: Array<Room>? = null
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
