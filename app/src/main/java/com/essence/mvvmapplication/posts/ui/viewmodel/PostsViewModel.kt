package com.essence.mvvmapplication.posts.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.essence.mvvmapplication.di.post.PostScope
import com.essence.mvvmapplication.posts.domain.PostsRepository
import com.essence.mvvmapplication.posts.model.PostModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@PostScope
class PostsViewModel @Inject constructor() : ViewModel() {
    @JvmField
    @Inject
    var postsRepository: PostsRepository? = null
    val liveData: MutableLiveData<List<PostModel?>?>
    val post: Unit
        get() {
            postsRepository!!.posts
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({ postModels: List<PostModel?>? -> liveData.setValue(postModels) }
                    ) { throwable: Throwable? -> Log.e(TAG, "PostsViewModel: ", throwable) }
        }

    companion object {
        private val TAG = PostsViewModel::class.java.simpleName
    }

    init {
        liveData = MutableLiveData()
    }
}