package com.example.uidemo.model

import android.graphics.Bitmap
import java.io.Serializable

data class EventAndActivitiesModel(
    var EventImage : Bitmap?,
    var EventName : String,
    var EventStartDate : String,
    var EventEndDate : String,
    var EventDetails : String,
    var EventPrice : Long,
    var EventIsActive : Boolean,
    var EventAbout : String,
    var EventSpeaker : ArrayList<EventSpeaker>,
    var EventCustomerReviews : CustomerReviews?,
    var EventVenue : String,
    var EventLocation : String?
) : Serializable{}

data class EventSpeaker(
  var speakerImage : Bitmap?,
  var speakerName : String,
  var speakerIntro : String
):Serializable{}

data class CustomerReviews(
    var averageRating : Float,
    var total5star : Long,
    var total4star : Long,
    var total3star : Long,
    var total2star : Long,
    var total1star : Long,
    var reviews : ArrayList<EventReview>
){
    fun getTotalReviews():Long{
        return total1star + total2star+ total3star+total4star+total5star
    }
}

data class EventReview(
    var ReviewTitle : String,
    var ReviewRating : Float,
    var ReviewComment : String,
    var ReviewBy : String,
    var ReviewDate : String
):Serializable{}