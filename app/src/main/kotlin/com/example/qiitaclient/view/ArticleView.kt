package com.example.qiitaclient.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.qiitaclient.R
import com.example.qiitaclient.bindView
import com.example.qiitaclient.model.Article

class ArticleView: FrameLayout {
    constructor(context: Context?): super(context!!)

    constructor(context: Context?,
                attrs: AttributeSet?): super(context!!, attrs)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context!!, attrs, defStyleAttr)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context!!, attrs, defStyleAttr, defStyleRes)

    private val profileImageView: ImageView by bindView(R.id.profile_image_view)

    private val titleTextView: TextView by bindView(R.id.title_text_view)

    private val userNameTextView: TextView by bindView(R.id.user_name_text_view)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_article, this)
    }

    fun setArticle(article: Article) {
        titleTextView.text = article.title
        userNameTextView.text = article.user.name

        // プロフィール画像をセットする
        Glide.with(context).load(article.user.profileImageUrl).into(profileImageView)
    }
}