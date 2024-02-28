package au.edu.swin.sdmd.l06_detailedimages

data class Location(val name: String, val author: String,
                    val latitude: Float, val longitude: Float,
                    var visited: Boolean = false) {
}
