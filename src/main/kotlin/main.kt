import model.*

class PostNotFoundException(message: String): RuntimeException (message)

fun main() {

}

fun viewPost(post: Post) {

    println("идентификатор записи: " + post.id)
    println("идентификатор владельца стены: " + post.ownerId)
    println("идентификатор автора записи: " + post.fromId)
    println("идентификатор администратора: " + post.createdBy)
    println("время публикации записи: " + post.date)
    println("текст записи: " + post.text)
    println("идентификатор владельца записи, в ответ на которую была оставлена текущая: " + post.replyOwnerId)
    println("идентификатор записи, в ответ на которую была оставлена текущая: " + post.replyPostIid)
    println("опция «Только для друзей»: " + post.friendsOnly)
    println("информация о комментариях к записи: " + post.comments)
    println("источник материала: " + post.copyright)
    println("информация о лайках к записи: " + post.likes)
    println("информация о репостах записи: " + post.reposts)
    println("информация о просмотрах записи: " + post.views)
    println("тип записи: " + post.postType)
//        println("информация о способе размещения записи: " + post.po
    println("медиавложения записи (фотографии, ссылки и т.п.): " + (post.attachments ?: "No Attachment this post"))
//        println("информация о местоположении: " + post.geo
    println("идентификатор автора: " + post.signerId)
//        println("история репостов для записи: " + post.co
    println("информация о том, может ли текущий пользователь закрепить запись: " + post.canPin)
    println("информация о том, может ли текущий пользователь удалить запись: " + post.canDelete)
    println("информация о том, может ли текущий пользователь редактировать запись: " + post.canEdit)
    println("информация о том, что запись закреплена: " + post.isPinned)
    println("информация о том, содержит ли запись отметку 'реклама': " + post.markedAsAds)
    println("объект добавлен в закладки у текущего пользователя?: " + post.isFavorite)
    println("информация о записи VK model.Donut: " + post.donut)
    println("идентификатор отложенной записи: " + post.postponedId)

}

fun getPostAttachment(post: Post) =
    post.attachments ?: "No attachment"

fun attachIs(attach: Attachment) = when (attach) {
    is Attachment.Link -> attach.type
    is Attachment.Graffiti -> attach.type
    is Attachment.Page -> attach.type
    is Attachment.App -> attach.type
    is Attachment.NotAttachment -> attach.type
}