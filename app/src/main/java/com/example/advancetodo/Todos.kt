package com.example.advancetodo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity
@Parcelize
data class Todos(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val Name : String,
    val Surname: String,
    val age: String
):Parcelable