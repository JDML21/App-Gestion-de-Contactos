import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacion.data.model.Contact

val title = TextStyle(
    fontSize = 24.sp,
    color = Color.Black
)

val body = TextStyle(
    fontSize = 16.sp,
    color = Color.Black
)


@Composable
fun ContactDetailScreen(contact: Contact) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Contact Detail",
            style = titleTextStyle
        )
        Divider()
        Text(
            text = "Name: ${contact.name}",
            style = bodyTextStyle
        )
        Text(
            text = "Phone: ${contact.phoneNumber}",
            style = bodyTextStyle
        )
        Text(
            text = "Email: ${contact.email}",
            style = bodyTextStyle
        )
    }
}
