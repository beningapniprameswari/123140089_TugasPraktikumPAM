@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package tugaspam7.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object AndroidMainDrawable0 {
  public val compose_multiplatform: DrawableResource by 
      lazy { init_compose_multiplatform() }
}

@InternalResourceApi
internal fun _collectAndroidMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("compose_multiplatform", AndroidMainDrawable0.compose_multiplatform)
}

internal val Res.drawable.compose_multiplatform: DrawableResource
  get() = AndroidMainDrawable0.compose_multiplatform

private fun init_compose_multiplatform(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:compose_multiplatform",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/tugaspam7.composeapp.generated.resources/drawable/compose-multiplatform.xml", -1, -1),
    )
)
