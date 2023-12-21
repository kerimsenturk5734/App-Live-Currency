import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applivecurrency.R
import com.example.applivecurrency.Tab

@Composable
fun BottomNavigationBar(selectedTab: Tab, onTabSelected: (Tab) -> Unit) {
    val foregroundColor = if(isSystemInDarkTheme()) Color.White else Color.Black
    val backgroundColor = if(isSystemInDarkTheme()) Color.Black else Color.White

    BottomAppBar(
        modifier = Modifier
            .background(backgroundColor)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp)),
        contentPadding = PaddingValues(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.exchange),
                    contentDescription = "Currencies") },

                label = { Text("Currencies") },
                selected = selectedTab == Tab.LIVE_CURRENCY,
                onClick = { onTabSelected(Tab.LIVE_CURRENCY) }
            )
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.favoriteicon),
                    contentDescription = "Favorites") },

                label = { Text("Favorites") },
                selected = selectedTab == Tab.FAVORITES,
                onClick = { onTabSelected(Tab.FAVORITES) }
            )
            BottomNavigationItem(
                icon = { Image(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.calculator),
                    contentDescription = "Calculator") },

                label = { Text("Calculator") },
                selected = selectedTab == Tab.CALCULATOR,
                onClick = { onTabSelected(Tab.CALCULATOR) }
            )
        }
    }
}