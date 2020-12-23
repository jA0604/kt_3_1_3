package model

data class Post (
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: String,
    val text: String,
    val replyOwnerId: Int,
    val replyPostIid: Int,
    val friendsOnly: Boolean,
    val postType: String,

    val attachments: Array<Attachment>?,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Repost,
    val views: Views
)