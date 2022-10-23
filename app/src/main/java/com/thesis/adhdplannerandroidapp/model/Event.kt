package com.thesis.adhdplannerandroidapp.model

import java.util.*

data class Event (
    val id: UUID,
    val name: String,
    val emailNotification: Boolean,
    val phoneNotification: Boolean,
    val smsNotification: Boolean,
    val executed: Boolean,
    val user: User
)
