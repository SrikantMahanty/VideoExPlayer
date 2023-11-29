package com.example.videoexplayer

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VideoAdpter(val context: Activity, val videolist: List<Hit>) :
    RecyclerView.Adapter<VideoAdpter.Videoholder>() {

    lateinit var mp: MediaPlayer

    class Videoholder(itemview: View) : RecyclerView.ViewHolder(itemview) {


        // val youTubePlayerView: VideoView = itemView.findViewById(R.id.videoview)
        //  val playerView: VideoView = itemView.findViewById(R.id.videoView)
        var title: TextView
        val image: ImageView
        var des: TextView
        val brandn: TextView
        val pricees: TextView
        val discountPercentages: TextView
        val ratings: TextView
        val stocks: TextView

        init {
            title = itemview.findViewById(R.id.tvTitle)
            image = itemview.findViewById(R.id.ivArticleImage)
            des = itemview.findViewById(R.id.tvdes)
            brandn = itemview.findViewById(R.id.Brand)
            pricees = itemview.findViewById(R.id.tvprice)
            discountPercentages = itemview.findViewById(R.id.tvDis)
            stocks = itemview.findViewById(R.id.tvstock)
            ratings = itemview.findViewById(R.id.tvRating)
            //val youTubePlayerView=findViewById<YouTubePlayerView>(R.id.Fullscreenview)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Videoholder {
        val itemview = LayoutInflater.from(context)
            .inflate(R.layout.item, parent, false)
        return Videoholder(itemview)
    }

    override fun getItemCount(): Int {
        return videolist.size
    }

    override fun onBindViewHolder(holder: Videoholder, position: Int) {
        val curritem = videolist[position]
        holder.title.text = curritem.duration.toString()
        holder.des.text = curritem.user_id.toString()
        holder.brandn.text = curritem.pageURL
        Picasso.get().load(curritem.userImageURL).into(holder.image);

//        holder.playerView.setVideoPath(curritem.userImageURL)
//        mp= MediaPlayer()
//        holder.playerView.setOnPreparedListener{
//            mp=it
//            it.start()
//        }
        holder.brandn.setOnClickListener {
            // Open the Pixabay video page in a browser
            Toast.makeText(context,curritem.pageURL, Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(curritem.pageURL))
            // val intent = Intent(context,Videoplay::class.java)
            context.startActivity(intent)
        }

        holder.pricees.text = curritem.tags
        holder.ratings.text = curritem.comments.toString()
        holder.discountPercentages.text=curritem.user
        holder.stocks.text=curritem.downloads.toString()
//        holder.ratings.text=curritem.rating.toString()

        // val videoId = extractVideoId(curritem.pageURL)

//        val videouri= Uri.parse(curritem.pageURL)
//        holder.youTubePlayerView.setVideoURI(videouri)
//        holder.youTubePlayerView.start()
//        holder.youTubePlayerView.setOnErrorListener { mp, what, extra ->
//            Log.e("VideoView", "Error during playback - what: $what, extra: $extra")
//            // Handle the error as needed
//            true
//        }


//        // Set up ExoPlayer
//        holder.playerView.player = holder.player
//        val mediaSource =Uri.parse(curritem.pageURL)
//        val mediaItem=MediaItem.fromUri(mediaSource)
//        SimpleExoPlayer.set
//        holder.player.prepare(mediaSource)
//        holder.player.playWhenReady = true

        // Initialize YouTubePlayer
//        holder.youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//            override fun onReady(youTubePlayer: YouTubePlayer) {
//                youTubePlayer.loadVideo(videoId, 0f)
//            }
//        })

    }

//    private fun buildMediaSource(uri: Uri): MediaSource {
//        val userAgent = "YourApp" // Replace with your app's name
//        val dataSourceFactory = DefaultDataSourceFactory(itemView.context, userAgent)
//        return ExtractorMediaSource.Factory(dataSourceFactory)
//            .createMediaSource(uri)
//    }

//    private fun extractVideoId(videoUrl: String): String {
//        // Extract video ID from YouTube URL
//        val uri = Uri.parse(videoUrl)
//        return uri.getQueryParameter("v") ?: uri.lastPathSegment ?: ""
//    }
}