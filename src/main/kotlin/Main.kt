package ru.netology

data class Post (
    val id : Int,
    val text: String,
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

class likes (
    var countLikes: Int,
    val user_likes: Int,
    var can_likes : Boolean,
   var can_publish: Boolean
)

object wallService {
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
        wallService.add(Post(1, "New day"))
        wallService.add(Post(1,"What are you doing?"))
        println(wallService.update(Post(2, "Something")))
        println(wallService.update(Post(4, "Wonderful new day!")))
        wallService.checkPost()
    }
