package br.com.garuca.testecvccorp.hotel

class Hotel(id:Int,
            name:String?,
            cityCode:Int,
            cityName:String?,
            roons: Roons?)

class Roons(roonID:Int,
            categoryName:String?,
            price: Price?)

class Price(adult:Float,
            child:Float)