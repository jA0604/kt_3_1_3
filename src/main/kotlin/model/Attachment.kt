package model

sealed class Attachment(
    val type: String,
    val attach: Attachment?
) {
    data class Graffiti(
        val id: Int,
        val ownerIid: Int,
        val photo130: String,
        val photo604: String
    ) : Attachment("graffiti", null)
    data class Link(
        val id: Int,
        val ownerId: Int,
        val url: String,
        val title: String,
        val caption: String,
        val description: String,
        val photo: Photo?,
        val product: Product?,
        val button: Button?,
        val previewPage: String,
        val previewUrl: String
    ) : Attachment("link", null)
    data class App(
        val id: Int,
        val ownerId: Int,
        val photo130: String,
        val photo604: String
    ) : Attachment("app", null)
    data class Page(
        val id: Int,
        val groupId: Int,
        val title: String
    ) : Attachment("page", null)
    object NotAttachment : Attachment("", null)
}
