package com.thesis.adhdplannerandroidapp.model

import java.util.*

class Card(
    val id: UUID,
    val events: List<Event>,
    val sumOfPoints: Int,
    val includePremium: Boolean
)
