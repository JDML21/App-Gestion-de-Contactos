import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacion.Presentation.viewModel.ContactListViewModel
import com.example.aplicacion.data.model.Contact

val titleTextStyle = TextStyle(
    fontSize = 24.sp,
    color = Color.Black
)

val bodyTextStyle = TextStyle(
    fontSize = 16.sp,
    color = Color.Gray
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(viewModel: ContactListViewModel) {
    val contacts = viewModel.contacts

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AppGes", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                content = { Icon(Icons.Filled.Add, contentDescription = "Add Contact") }
            )
        })
     {
        ContactList(contacts = contacts)
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Contacts",
            style = titleTextStyle
        )
        Divider()
        contacts.forEach { contact ->
            ContactItem(contact = contact)
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { /*TODO*/ }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
       Text(
            text = contact.name,
            style = bodyTextStyle
        )
        Text(
            text = contact.phoneNumber,
            style = bodyTextStyle
        )
    }
}