package model

data class Comment (
    val id: Int = 0,
    val fromId: Int,
    val date: Long,
    val text: String,
    val donut: Donut,
    val isDon: Boolean,
    val placeholder: String,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Array<Attachment>,
    val parentsStack: Array<Int>,
    val threadComments: ThreadComments
    ) {

}
