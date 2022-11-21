package com.thesis.adhdplannerandroidapp.model

import java.util.*

class Premium(
    val id: UUID,
    val user: User,
    val premiumOn: Boolean,
    val adsOff: Boolean,
    val effectiveStart: Date,
    val effectiveEnd: Date
)
