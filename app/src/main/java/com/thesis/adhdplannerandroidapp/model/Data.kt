package com.thesis.adhdplannerandroidapp.model

import java.util.*


class User {
    var id: Int? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var phoneNumber: String? = null
    var events: List<Event>? = null
    var premium: Premium? = null
    var confirmedEmail: Boolean? = null
}

class Premium {
    var id: UUID? = null
    var premiumOn: Boolean? = null
    var adsOff: Boolean? = null
    var effectiveStart: Date? = null
    var effectiveEnd: Date? = null
}

class DailyPlan {
    var id: UUID? = null
    var name: String? = null
    var type: String? = null
    var description: String? = null
    var event: Event? = null
    var effectiveStart: Date? = null
    var effectiveEnd: Date? = null
}

class Card{
    var id: UUID? = null
    var events: List<Event>? = null
    var sumOfPoints: Int? = null
    var includePremium: Boolean? = null
}

class Event {
    var id: UUID? = null
    var name: String? = null
    var emailNotification: Boolean? = null
    var phoneNotification: Boolean? = null
    var smsNotification: Boolean? = null
    var executed: Boolean? = null
    var user: User? = null
    var dailyPlans: List<DailyPlan>? = null
    var card: Card? = null
}





