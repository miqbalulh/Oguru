package com.example.oguru.Model

class TentorModel(
    val idTentor: String,
    val firstname: String,
    val lastname: String,
    val alamat: String,
    val tgllahir: String,
    val tempatlahir: String,
    val email: String,
    val notelp: String,
    val pendidikanterakhir: String,
    val username: String,
    val password: String,
    val bidang: String
){
    constructor() : this("", "", "", "","","","","","",
        "","","")
}