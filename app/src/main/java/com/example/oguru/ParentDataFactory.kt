package com.example.oguru

import kotlin.random.Random

object ParentDataFactory {
    private val random = Random

    private val jadwal =  arrayListOf( "10 Februari 2020", "11 Februari 2020", "15 Februari 2020", "16 Februari 2020", "18 Februari 2020")

    private fun randomJadwal() : String{
        val index = random.nextInt(jadwal.size)
        return jadwal[index]
    }

    private fun randomChildren() : List<childModel>{
        return ChildDataFactory.getChildren(Random.nextInt(1, 3))
    }

    fun getParents(count : Int) : List<parentModel>{
        val parents = mutableListOf<parentModel>()
        repeat(count){
            val parent = parentModel(randomJadwal(), randomChildren())
            parents.add(parent)
        }
        return parents
    }
}