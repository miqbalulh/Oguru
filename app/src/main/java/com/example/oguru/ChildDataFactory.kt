package com.example.oguru

import kotlin.random.Random

object ChildDataFactory {
    private val random = Random

    private val mapel =  arrayListOf( "Bahasa Inggris", "Bahasa Indonesia", "Matematika", "IPA")
    private val jam =  arrayListOf( "08.00 - 10.00 WIB", "10.00 - 12.00 WIB", "14.00 - 16.00 WIB", "18.00 - 20.00 WIB")
    private val alamat =  arrayListOf( "Perumahan Palem Putri Blok  R/3 Balonggabus Candi Sidoarjo", "Desa Bedoho Kecamatan Sooko Kabupaten Ponorogo", "Tulungagung", "Magetan")

    private fun randomMapel() : String{
        val index = random.nextInt(mapel.size)
        return mapel[index]
    }

    private fun randomJam() : String{
        val index = random.nextInt(jam.size)
        return jam[index]
    }

    private fun randomAlamat() : String{
        val index = random.nextInt(alamat.size)
        return alamat[index]
    }


    fun getChildren(count : Int) : List<childModel>{
        val children = mutableListOf<childModel>()
        repeat(count){
            val child = childModel(randomMapel(), randomJam(), randomAlamat())
            children.add(child)
        }
        return children
    }
}