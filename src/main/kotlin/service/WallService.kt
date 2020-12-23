package service

import PostNotFoundException
import model.*
import java.lang.Exception

class WallService {

    private var id = 0
    private var idComment = 0

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Reports>()

    fun add(post: Post): Post {
        val copy = post.copy(id = id++)
        posts += copy
        return copy
    }

    fun remove(removeId: Int): Int {
        val postWithoutId = posts.filterIndexed { index, s -> (index != removeId) }
        posts = postWithoutId.toTypedArray()
        return --id
    }

    fun findById(id: Int): Post {
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        return throw PostNotFoundException("no post with id $id")
    }

    fun likeById(id: Int): Int {
        posts.forEachIndexed { index, post ->
            if (index == id) {
                val countLikes = posts[index].likes.countLikes + 1
                val countDislakes = posts[index].likes.countDislikes
                posts[index] = posts[index].copy(likes = Likes(countLikes, countDislakes))
                return posts[index].likes.countLikes
            }
        }
        return 0
    }

    fun dislikeById(id: Int): Int {
        for (post in posts) {
            if (post.id == id) {
                val countLikes = posts[id].likes.countLikes
                val countDislakes = posts[id].likes.countDislikes + 1
                posts[id] = posts[id].copy(likes = Likes(countLikes, countDislakes))
                return posts[id].likes.countDislikes
            }
        }
        return 0
    }

    fun sizeWallPosts() = posts.size
    fun sizeWallComments() = comments.size
    fun sizeWallReports() = reports.size


    fun update(post: Post): Boolean {
        posts.map {
            if (it.id == post.id) {
                val itId = it.id
                val itOwnerId = it.ownerId
                val itDate = it.date
                val copy = post.copy(id = itId, ownerId = itOwnerId, date = itDate)
                posts.set(itId, copy)
                return true
            }
        }
        return false
    }

    fun get(id: Int) = posts[id]


    fun createComment(comment: Comment, idPost: Int): Comment {
        for (post in posts) {
            if (post.id == idPost) {
                val copyComment = comment.copy(id = idComment++)
                comments += copyComment
                return copyComment
            }
        }
        return throw PostNotFoundException("No post with id $idPost")

    }

    fun createReportComment(idPost: Int, idComment: Int, report: Reports) {
        var newRepot = report
        for (post in posts) {
            if (post.id == idPost) {
                newRepot = newRepot.copy(postId = post.id)
                for (comment in comments) {
                    if (comment.id == idComment) {
                        newRepot = newRepot.copy(commentId = comment.id)
                        reports += newRepot
                        return
                    }
                }
                return throw PostNotFoundException("No comment with id $idComment")
            }
        }
        return throw PostNotFoundException("No post with id $idPost")

    }
}

