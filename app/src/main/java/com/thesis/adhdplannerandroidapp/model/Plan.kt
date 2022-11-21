package com.thesis.adhdplannerandroidapp.model

import java.util.*

class Plan(

    val id: UUID,
    val name: String,
    val type: String,
    val description: String,
    val event: Event,
    val effectiveDate: Date,
    val effectiveEnd: Date
)