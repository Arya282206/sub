package com.dicoding.picodiploma.myfinalsubmission

import android.os.Parcelable
import android.provider.ContactsContract.Contacts.Photo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val photo: Int,
    val detail: String,
    val voice: String
) : Parcelable
