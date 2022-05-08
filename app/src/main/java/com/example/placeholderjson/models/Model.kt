package com.example.placeholderjson.models


data class Address(
    var city : String,
    var zipcode : String
)

data class Company(
    var name : String
)

data class Root(
    var id : Int,
    var name : String,
    var address: Address,
    var company: Company
)