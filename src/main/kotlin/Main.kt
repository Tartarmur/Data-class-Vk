package ru.netology

abstract class Attachment (
    val type : String
)

data class Audio (val id: Int, val duration : Int, val artist : String)
data class Video (val id: Int, val duration: Int, val description : String)
data class Photo (val id: Int, val owner_id: Int, val text : String)
data class Note (val id: Int, val title: String,  val text : String)
data class Link (val url: String, val title: String, val description : String)

data class AudioAttachment (val audio: Audio) : Attachment ("audio")
data class VideoAttachment (val video: Video) : Attachment ("video")
data class PhotoAttachment (val photo: Photo) : Attachment ("photo")
data class NoteAttachment (val note: Note) : Attachment ("note")
data class LinkAttachment (val link: Link) : Attachment ("link")

data class Post (
    val id : Int?,
    val text: String?,
    var attachments : Array<Attachment> = emptyArray()
    //val owner_id: Int,
    //val from_id: Int,
    //val created_by: Int,
    //val date: Int,
    //val reply_owner_id: Int,
    //val reply_post_id: Int,
    //val friends_only: Boolean
)

class Comments (
    var countComments : Int,
    var can_post: Boolean,
    var groups_can_post: Boolean,
    var can_close: Boolean,
    var can_open: Boolean,
)

class Likes (
    var countLikes: Int,
    val user_likes: Int,
    var can_likes : Boolean,
   var can_publish: Boolean
)




object WallService {
    private var posts = emptyArray<Post>()
    private var unicumId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++unicumId)
        return posts.last()
    }

    fun update (updatePost: Post):Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == updatePost.id) {
                posts[index] = updatePost.copy(text = updatePost.text)
                return true
            }
        }
        return false
    }

    fun checkPost() {
        for (post in posts) {
            print(post)
            println()
        }
    }

    fun clear() {
        posts = emptyArray()
    }
}



    fun main() {
        WallService.add(Post(1, "New day"))
        WallService.add(Post(1,"What are you doing?"))
        WallService.update(Post(2, "Something",
            arrayOf(PhotoAttachment(Photo(6, 4,"New photo")),(NoteAttachment(Note(4, "New Note", "Check update"))))))
        WallService.update(Post(4, "Wonderful new day!"))
        WallService.checkPost()
    }
