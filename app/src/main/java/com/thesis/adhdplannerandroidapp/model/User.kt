package com.thesis.adhdplannerandroidapp.model

import java.util.*

data class User (
    val id: UUID,
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val events: List<Event>,
    val premium: Premium,
    val confirmedEmail: Boolean
    )