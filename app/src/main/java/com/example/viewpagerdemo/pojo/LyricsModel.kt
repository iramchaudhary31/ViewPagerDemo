package com.example.viewpagerdemo.pojo


import com.google.gson.annotations.SerializedName

data class LyricsModel(
    @SerializedName("message")
    var message: Message
) {
    data class Message(
        @SerializedName("body")
        var body: Body,
        @SerializedName("header")
        var header: Header
    ) {
        data class Body(
            @SerializedName("track_list")
            var trackList: ArrayList<Track>
        ) {
            data class Track(
                @SerializedName("track")
                var track: Track
            ) {
                data class Track(
                    @SerializedName("album_id")
                    var albumId: Int,
                    @SerializedName("album_name")
                    var albumName: String,
                    @SerializedName("artist_id")
                    var artistId: Int,
                    @SerializedName("artist_name")
                    var artistName: String,
                    @SerializedName("commontrack_id")
                    var commontrackId: Int,
                    @SerializedName("explicit")
                    var explicit: Int,
                    @SerializedName("has_lyrics")
                    var hasLyrics: Int,
                    @SerializedName("has_richsync")
                    var hasRichsync: Int,
                    @SerializedName("has_subtitles")
                    var hasSubtitles: Int,
                    @SerializedName("instrumental")
                    var instrumental: Int,
                    @SerializedName("num_favourite")
                    var numFavourite: Int,
                    @SerializedName("primary_genres")
                    var primaryGenres: PrimaryGenres,
                    @SerializedName("restricted")
                    var restricted: Int,
                    @SerializedName("track_edit_url")
                    var trackEditUrl: String,
                    @SerializedName("track_id")
                    var trackId: Int,
                    @SerializedName("track_name")
                    var trackName: String,
                    @SerializedName("track_name_translation_list")
                    var trackNameTranslationList: List<Any>,
                    @SerializedName("track_rating")
                    var trackRating: Int,
                    @SerializedName("track_share_url")
                    var trackShareUrl: String,
                    @SerializedName("updated_time")
                    var updatedTime: String
                ) {
                    data class PrimaryGenres(
                        @SerializedName("music_genre_list")
                        var musicGenreList: List<MusicGenre>
                    ) {
                        data class MusicGenre(
                            @SerializedName("music_genre")
                            var musicGenre: MusicGenre
                        ) {
                            data class MusicGenre(
                                @SerializedName("music_genre_id")
                                var musicGenreId: Int,
                                @SerializedName("music_genre_name")
                                var musicGenreName: String,
                                @SerializedName("music_genre_name_extended")
                                var musicGenreNameExtended: String,
                                @SerializedName("music_genre_parent_id")
                                var musicGenreParentId: Int,
                                @SerializedName("music_genre_vanity")
                                var musicGenreVanity: String
                            )
                        }
                    }
                }
            }
        }

        data class Header(
            @SerializedName("execute_time")
            var executeTime: Double,
            @SerializedName("status_code")
            var statusCode: Int
        )
    }
}