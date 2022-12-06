package com.thesis.adhdplannerandroidapp.model

import java.util.*

class DailyPlan (
    val id: UUID,
    val name: String,
    val type: String,
    val description: String,
    val event: Event,
    val effectiveStart: Date,
    val effectiveEnd: Date
)