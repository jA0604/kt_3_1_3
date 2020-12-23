package model

data class Reports (
    val id: Int,
    val date: Long,
    val text: String,
    val reason: Reason,
    val commentId: Int,
    val postId: Int
    )
{

}
