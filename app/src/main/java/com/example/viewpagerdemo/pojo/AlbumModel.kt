package com.example.viewpagerdemo.pojo


import com.google.gson.annotations.SerializedName

data class AlbumModel(
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
            @SerializedName("album_list")
            var albumList: ArrayList<Album>
        ) {
            data class Album(
                @SerializedName("album")
                var album: Album
            ) {
                data class Album(
                    @SerializedName("album_copyright")
                    var albumCopyright: String,
                    @SerializedName("album_id")
                    var albumId: Int,
                    @SerializedName("album_label")
                    var albumLabel: String,
                    @SerializedName("album_mbid")
                    var albumMbid: String,
                    @SerializedName("album_name")
                    var albumName: String,
                    @SerializedName("album_pline")
                    var albumPline: String,
                    @SerializedName("album_rating")
                    var albumRating: Int,
                    @SerializedName("album_release_date")
                    var albumReleaseDate: String,
                    @SerializedName("artist_id")
                    var artistId: Int,
                    @SerializedName("artist_name")
                    var artistName: String,
                    @SerializedName("primary_genres")
                    var primaryGenres: PrimaryGenres,
                    @SerializedName("restricted")
                    var restricted: Int,
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
            @SerializedName("available")
            var available: Int,
            @SerializedName("execute_time")
            var executeTime: Double,
            @SerializedName("status_code")
            var statusCode: Int
        )
    }
}