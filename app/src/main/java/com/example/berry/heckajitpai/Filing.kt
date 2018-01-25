package com.example.berry.heckajitpai

/**
 * Created by per6 on 1/23/18.
 */
data class Filing(var submissionType: SubmissionType, var confirmationNumber: Int, var contactEmail: String, var addressEntity: AddressEntity, var textData: String) {
}